package it.alfasoft.ecommerce.local.dao;

import it.alfasoft.ecommerce.local.dto.Comune;
import it.alfasoft.ecommerce.local.dto.Provincia;
import it.alfasoft.ecommerce.local.dto.Regione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOLocalita extends ADao implements IDAOLocalita {

	private static String SQLREGIONI = "SELECT * FROM REGIONI";

	public DAOLocalita() throws ClassNotFoundException {
		super();
	}

	@Override
	public List<Regione> leggiRegioni() throws SQLException {

		Connection connessione = DriverManager.getConnection(url, "corso",
				"corso");
		Statement statement = connessione.createStatement();

		List<Regione> regioni = new ArrayList<Regione>();

		ResultSet rs = statement.executeQuery(SQLREGIONI);

		while (rs.next()) {
			Regione regione = new Regione();
			regione.setId(rs.getInt("IDREGIONE"));
			regione.setNome(rs.getString("NOMEREGIONE"));
			regioni.add(regione);
		}
		connessione.close();
		return regioni;
	}

	@Override
	public List<Provincia> leggiProvince(int idRegione) throws SQLException {
		Connection connessione = DriverManager.getConnection(url, "corso",
				"corso");
		Statement statement = connessione.createStatement();
		String sqlprovince = "SELECT * FROM PROVINCE WHERE IDREGIONE="
				+ idRegione;
		ResultSet rs = statement.executeQuery(sqlprovince);
		List<Provincia> province = new ArrayList<Provincia>();

		while (rs.next()) {
			Provincia provincia = new Provincia();
			provincia.setIdprovincia(rs.getInt("IDPROVINCIA"));
			provincia.setIdregione(rs.getInt("IDREGIONE"));
			provincia.setNomeprovincia(rs.getString("NOMEPROVINCIA"));
			provincia.setSiglaprovincia(rs.getString("SIGLAPROVINCIA"));
			province.add(provincia);
		}
		connessione.close();
		return province;
	}

	@Override
	public List<Comune> leggiComuni(int idregione, int idprovincia)
			throws SQLException {
		Connection connessione = DriverManager.getConnection(url, "corso",
				"corso");
		Statement statement = connessione.createStatement();
		String sqlcomuni = "SELECT * FROM COMUNI where IDREGIONE=" + idregione
				+ " AND IDPROVINCIA=" + idprovincia;

		ResultSet rs = statement.executeQuery(sqlcomuni);
		List<Comune> comuni = new ArrayList<Comune>();

		while (rs.next()) {
			Comune comune = new Comune();
			comune.setId(rs.getInt("ID"));
			comune.setIdprovincia(rs.getInt("IDPROVINCIA"));
			comune.setNomecomune(rs.getString("NOME"));
			comune.setCatasto(rs.getString("CATASTO"));
			comuni.add(comune);
		}
		connessione.close();
		return comuni;
	}

}
