package uplord.uplordapi.common.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uplord.uplordapi.common.dao.FileDAO;
import uplord.uplordapi.common.domain.FileKey;
import uplord.uplordapi.common.service.FileService;
import uplord.uplordapi.dto.FileDTO;
import uplord.uplordapi.enums.DeleteType;
import uplord.uplordapi.util.FileUtil;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeneralFileService implements FileService {

    private final FileDAO fileDao;

    @Override
    public FileDTO getFile(FileKey fileKey) {
        FileDTO param = new FileDTO();
        param.setFileIdx(fileKey.getFileIdx());
        param.setFileSrlno(fileKey.getFileSrlno());
        return fileDao.findOne(param);
    }

    @Override
    public List<FileDTO> getAllFiles(Integer fileIdx) {
        FileDTO param = new FileDTO();
        param.setFileIdx(fileIdx);
        return fileDao.findAll(param);
    }

    @Override
    public FileKey save(List<MultipartFile> files) {
        return this.save(files, fileDao.nextIdx());
    }

    @Override
    public FileKey save(List<MultipartFile> files, Integer fileIdx) {
        FileKey fileKey = new FileKey(fileIdx);

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);

            FileDTO seqParam = new FileDTO();
            seqParam.setFileIdx(fileIdx);
            Integer fileSeq = fileDao.nextSeq(seqParam);

            FileDTO param = new FileDTO();
            param.setFileIdx(fileIdx);
            param.setFileSrlno(fileSeq);
            param.setDeleteAt(DeleteType.N);
            param.setName(file.getOriginalFilename());
            param.setType(file.getContentType());
            param.setSize(file.getSize());
            param.setSortOrder(i + 1);
            param.setSrc(FileUtil.toBytes(file));

            int savedCount = fileDao.save(param);

            if (savedCount == 0) {
                throw new RuntimeException("Not saved file" + file.getName());
            }
        }
        return fileKey;
    }

    @Override
    public void deleteFile(FileKey fileKey) {
        FileDTO param = new FileDTO();
        param.setFileIdx(fileKey.getFileIdx());
        param.setFileSrlno(fileKey.getFileSrlno());
        int deletedCount = fileDao.deleteOne(param);
        
        if (deletedCount == 0) {
            throw new RuntimeException("Failed delete a file. fileIdx: " + fileKey.getFileIdx() + ", fileSrlno: " + fileKey.getFileSrlno());
        }
    }

    @Override
    public void deleteAllFiles(Integer fileIdx) {
        FileDTO param = new FileDTO();
        param.setFileIdx(fileIdx);
        int deletedCount = fileDao.deleteAll(param);

        if (deletedCount == 0) {
            throw new RuntimeException("Failed delete all files. fileIdx: " + fileIdx);
        }
    }

}