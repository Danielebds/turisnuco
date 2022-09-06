import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario() {
	}
	

	
	public Usuario(String nome, String email, String senha) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public void criar() {
		System.out.println("tá no criar");
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		String sql = "INSERT INTO clientes (id, email, nome, senha) values(default, ?, ?, ?)";
		
		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			ResultSet rset = pstm.executeQuery();

			while (rset.next()) {
				this.setId(rset.getInt("cod_cli"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void atualizar() {
		
	}
	
	public void buscar() {
		
	}
	
	public void apagar() {
		
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
