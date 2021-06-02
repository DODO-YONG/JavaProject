package dao;
//DTO 객체 : 자바의 계층간 데이터 전송을 담당하는 객체
//필드, getter/setter, toString, equals 정도의 메서드만 작성
//반드시 기본 생성자가 있어야함
//일반적으로 로직 메서드는 작성하지 않는다.
public class ProjectVO {
	private Long id;
	private String name;
	private String hp;
	private String tel;
	
	//	생성자
	public ProjectVO(Long id,
				String name,
				String hp,
				String tel) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.tel = tel;		
	}
	public String getName() {
		return name;
	}
	public String getHp() {
		return hp;
	}
	public String getTel() {
		return tel;
	}
	public Long getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProjectVO [id=" + id + ",name=" + name + ", hp=" + hp + ", tel=" + tel + "]";
	}
	

}
