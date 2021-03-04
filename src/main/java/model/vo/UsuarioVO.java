package model.vo;

public class UsuarioVO {
	
	private int idUsuario;
	private String nome;
	private String telefone;
	private String cpf;
	private String login ;
	private String senha;
	
	public UsuarioVO() {
		super();
	}

	public UsuarioVO(int idUsuario, String nome, String telefone, String cpf, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}
