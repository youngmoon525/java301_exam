package package2;

import package1.B;
//import라는것은 다른 패키지에 있는 기능을 사용하기위해서 기능을 '추가'
//한다 라고 생각을 하면됨.
// 패키지.*; <-패키지에 하위에 있는 전부를 뜻함.
// 패키지.B; <-선택한 클래스만 사용하겠다.

public class C {
	// A클래스와 B클래스 접근해보기. (생성)
	//A a = new A(); default 접근제한자로 지정되어있는 class는
					//다른 패키지에서는 접근을 할수가 없다.
	B b =  new B();//
	//public 접근제하자는 같은 자바프로젝트 내에서 언제든지 접근할수있게
	//되어있는 접근 제한자이다.
}
