CustomMemoPackage
=================

나만의 메모기능 패키지

클래스 설명
-----------

-	MemoModel : 데이터의 효율적 이용을 위해 추상화한 데이터모델. extends RealmObject 는 reaml database 를 사용하기 위해 상속된 클래스. 또한 반드시 공백 생성자를 포함하고 있어야한다.

-	MemoModelInterface : 데이터모델에 가변적인 변화에도 타 클래스를 수정하기 않기 위해 인터페이스 조립. getMemo()를 필수적으로 설정.

-	MemoDatabaseUtil : 메모내용에 대해 데이터베이스와 연관된 기능을 갖고있는 클래스. 데이터베이스 연결 , 메모 저장, 메모 불러오기, 삭제 등을 포함하고 있다. 예제는 realm database를 사용한 클래스로 되어있다.

-	DatabaseInterface : 데이터베이스 유틸리티에 대해 반드시 포함해야할 기능을 설정하기 위해 작성된 인터페이스.

-	void connectDB() : 데이터베이스 연결

-	void saveMemo(MemoModelInterface memoModelInterface) : 데이터모델 인터페이스를 받아 메모를 저장하는 메소드.

-	ArrayList<MemoModelInterface> loadMemo() : 메모 전체를 전달하는 메소드.

-	void deleteMemoInDB(String memoTxt) : 메모중 지정한 메모를 지우는 메소드.

-	void closeDB() : 데이터베이스 연결을 중단하는 메소드.
