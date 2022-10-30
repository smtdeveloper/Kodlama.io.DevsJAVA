
package kodlama.io.Kodlama.io.Devs.entities.conretes;

public class Language {

	private int id;
	private String name;
	private Boolean isDelete;
	// smt

	public Language() {
		super();
	}

	public Language(int id, String name, Boolean isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}
