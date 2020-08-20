# multi-modules-test-project


-	멀티모듈 프로젝트 ??

	-	기존의 단일 프로젝트들을 프로젝트 안의 모듈로서 갖을 수 있게 하여 다중 모듈을 한 프로젝트에서 관리한다.

	-	독립적인 프로젝트들이 모여 동작하는 한 시스템을 개발하는 경우 독립적인 시스템들이 동일하게 사용하는 부분을 동일하게 각각의 프로젝트에서 구현해야 한다. (ex_ Domain, Repository 등)

	-	이 경우 공통부분에 변경이 생기면 모든 독립적인 프로젝트에도 동일하게 변경을 해줘야한다.

		-	상당히 비효율적이다. 실수발생 가능성도 높다.
		
	- 멀티모듈을 통해서 루트프로젝트 내 여러곳에서 공통적으로 사용되는 부분을 모듈로 분리해서 관리할 수있다.


-	문제점

	-	1) 그래들 6.4.1 오류 발생

		-	생성 시 6.4.1로 설정되었는데 빌드가 안된다! 검색을 해보면 인털리제이 이슈로 나온다

		-	버전을 낮췄다.. 6.4.1 -> 5.6.1

		-	프로젝트 경로에서 다음을 실행하면 된다.

		> ./gradlew wrapper --gradle-version 5.6.1

		-	나는 gradle/wrapper/gradle-wrapper.properties 에서 버전을 바꿔주었다. 위의 방법이 맞는 방법 같다.

			```java
			distributionBase=GRADLE_USER_HOME
			distributionPath=wrapper/dists
			distributionUrl=https\://services.gradle.org/distributions/gradle-5.6.1-bin.zip
			zipStoreBase=GRADLE_USER_HOME
			zipStorePath=wrapper/dists
			```

	-	2) common에 생성한 repository나 domain을 자꾸 인식을 못하여 다음과 같이 Application에 명시해줌 
		- (패키지 수정 후 해당 어노테이션 삭제함)

		```java
		@SpringBootApplication(scanBasePackages = "com.example")
		@EntityScan("com.example.domain")
		@EnableJpaRepositories(basePackages={"com.example.repository"})
		```

		-	해결! : 생성한 repository 경로가 다른 모듈과 달랐음! 

			-	기존 common 모듈 : com.example.domain.Member.java
			-	기존 api 모듈 : com.example.multimodulestestproject.ModuleApiApplication.java
			-	변경 common모듈 : com.example.domain.multimodulestestproject.Member.java
      
      
---

-	프로젝트 생성 참고: https://www.hanumoka.net/2019/10/04/springBoot-20191004-springboot-gradle-multimodule/

-	멀티모듈 생성 참고 : https://jojoldu.tistory.com/123

