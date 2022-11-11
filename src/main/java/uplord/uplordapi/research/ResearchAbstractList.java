package uplord.uplordapi.research;
// 코드 리펙토링 및 객체지향적 프로그래밍을 위한 개발 연구 리스트
/* 얀구 리스트
- 디자인패턴( 템플릿 패턴, 전략 패턴,
- AOP (
- DI ( 방식 효율성 : 생성자 주입, 필드주입, 메서드 주입 )
- annotation ( 각 어노테이션이 어떤 코드로 이루어져있고, 그 어노테이션으로 활용하면 좋을 상황은 언제인지. \
    ex) @Autowired, @Resource, @Qualifier, @Value
 */
public abstract class ResearchAbstractList<T> {
    public abstract T DesignPatternResearcher ();

    public abstract T AOPResearcher ();

    public abstract T DIResearcher ();

    public abstract T AnnotationResearcher ();

}
