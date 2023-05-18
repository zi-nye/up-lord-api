#!/usr/bin/env bash

function find_idle_profile() {
  RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)

  if [ ${RESPONSE_CODE} -ge 400 ]; then
    CURRENT_PROFILE=real2
  else
    CURRENT_PROFILE=$(curl -s http://localhost/profile)
  fi

  if [ ${CURRENT_PROFILE} == real1 ]; then
    IDLE_PROFILE=real2
  else
    IDLE_PROFILE=real1
  fi

  echo "NGINX 와 연결되지 않은 프로필 : ${IDLE_PROFILE}"
}

function find_idle_port() {
  IDLE_PROFILE=$(find_idle_profile)

  if [ ${IDLE_PROFILE} == real1 ]; then
    echo "사용하지 않는 프로필인 ${IDLE_PROFILE}에 세팅된 포트번호 8081"
  else
    echo "사용하지 않는 프로필인 ${IDLE_PROFILE}에 세팅된 포트번호 8082"
  fi
}
