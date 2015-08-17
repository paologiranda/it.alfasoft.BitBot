package it.alfasoft.ecommerce.integration;

import it.alfasoft.ecommerce.integration.dto.Categoria;
import it.alfasoft.ecommerce.integration.dto.Prodotto;
import it.alfasoft.ecommerce.integration.dto.SottoCategoria;
import it.alfasoft.ecommerce.integration.dto.Tipo;
import it.alfasoft.ecommerce.integration.exception.ProdottoInesistente;

import java.util.ArrayList;
import java.util.Date;

public class MagazzinoMock implements MagService {
	private ArrayList<Prodotto> elencoProdotti;

	public MagazzinoMock() {
		elencoProdotti=new ArrayList<Prodotto>();
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV001", "kit Videosorveglianza base", "bla bla bla...", false, 100));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV002", "kit Videosorveglianza pro", "bla bla bla...", false,150));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sicurezza, Tipo.Prodotto, "SICR001", "Sitema sicurezza base", "bla bla bla...", false, 40));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sicurezza, Tipo.Prodotto, "SICR002", "Sitema sicurezza pro", "bla bla bla...", false, 70));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Domotica, Tipo.Prodotto, "DOMO001", "Domotica base", "bla bla bla...", false, 90));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Domotica, Tipo.Prodotto, "DOMO002", "Domotica PRO", "bla bla bla...", false, 190));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Automation, Tipo.Prodotto, "AUTO001", "Controllo presenze", "bla bla bla...", true,100));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Automation, Tipo.Prodotto, "AUTO002", "Automazione Entrate", "bla bla bla...", true,50));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV3", "ProdottoElett.Sorv 1", "bla bla bla...", false,76));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV4", "ProdottoElett.Sorv 2", "bla bla bla...", false,70));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV5", "ProdottoElett.Sorv 3", "bla bla bla...", false,107));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV6", "ProdottoElett.Sorv 4", "bla bla bla...", false,142));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV7", "ProdottoElett.Sorv 5", "bla bla bla...", false,110));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV8", "ProdottoElett.Sorv 6", "bla bla bla...", false,103));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV9", "ProdottoElett.Sorv 7", "bla bla bla...", false,50));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV10", "ProdottoElett.Sorv 8", "bla bla bla...", false,45));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV11", "ProdottoElett.Sorv 9", "bla bla bla...", false,107));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV12", "ProdottoElett.Sorv 10", "bla bla bla...", false,115));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV13", "ProdottoElett.Sorv 11", "bla bla bla...", false,126));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV14", "ProdottoElett.Sorv 12", "bla bla bla...", false,79));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV15", "ProdottoElett.Sorv 13", "bla bla bla...", false,71));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV16", "ProdottoElett.Sorv 14", "bla bla bla...", false,71));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV17", "ProdottoElett.Sorv 15", "bla bla bla...", false,40));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV18", "ProdottoElett.Sorv 16", "bla bla bla...", false,49));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV19", "ProdottoElett.Sorv 17", "bla bla bla...", false,108));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV20", "ProdottoElett.Sorv 18", "bla bla bla...", false,53));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV21", "ProdottoElett.Sorv 19", "bla bla bla...", false,104));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV22", "ProdottoElett.Sorv 20", "bla bla bla...", false,166));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV23", "ProdottoElett.Sorv 21", "bla bla bla...", false,114));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV24", "ProdottoElett.Sorv 22", "bla bla bla...", false,99));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV25", "ProdottoElett.Sorv 23", "bla bla bla...", false,72));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV26", "ProdottoElett.Sorv 24", "bla bla bla...", false,59));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV27", "ProdottoElett.Sorv 25", "bla bla bla...", false,78));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV28", "ProdottoElett.Sorv 26", "bla bla bla...", false,36));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV29", "ProdottoElett.Sorv 27", "bla bla bla...", false,43));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV30", "ProdottoElett.Sorv 28", "bla bla bla...", false,167));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV31", "ProdottoElett.Sorv 29", "bla bla bla...", false,97));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV32", "ProdottoElett.Sorv 30", "bla bla bla...", false,146));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV33", "ProdottoElett.Sorv 31", "bla bla bla...", false,177));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV34", "ProdottoElett.Sorv 32", "bla bla bla...", false,144));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV35", "ProdottoElett.Sorv 33", "bla bla bla...", false,41));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV36", "ProdottoElett.Sorv 34", "bla bla bla...", false,23));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV37", "ProdottoElett.Sorv 35", "bla bla bla...", false,60));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV38", "ProdottoElett.Sorv 36", "bla bla bla...", false,71));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV39", "ProdottoElett.Sorv 37", "bla bla bla...", false,134));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV40", "ProdottoElett.Sorv 38", "bla bla bla...", false,48));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV41", "ProdottoElett.Sorv 39", "bla bla bla...", false,112));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV42", "ProdottoElett.Sorv 40", "bla bla bla...", false,103));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV43", "ProdottoElett.Sorv 41", "bla bla bla...", false,129));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV44", "ProdottoElett.Sorv 42", "bla bla bla...", false,40));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV45", "ProdottoElett.Sorv 43", "bla bla bla...", false,80));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV46", "ProdottoElett.Sorv 44", "bla bla bla...", false,50));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV47", "ProdottoElett.Sorv 45", "bla bla bla...", false,157));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV48", "ProdottoElett.Sorv 46", "bla bla bla...", false,166));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV49", "ProdottoElett.Sorv 47", "bla bla bla...", false,32));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV50", "ProdottoElett.Sorv 48", "bla bla bla...", false,175));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV51", "ProdottoElett.Sorv 49", "bla bla bla...", false,68));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV52", "ProdottoElett.Sorv 50", "bla bla bla...", false,32));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV53", "ProdottoElett.Sorv 51", "bla bla bla...", false,150));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV54", "ProdottoElett.Sorv 52", "bla bla bla...", false,77));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV55", "ProdottoElett.Sorv 53", "bla bla bla...", false,147));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV56", "ProdottoElett.Sorv 54", "bla bla bla...", false,101));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV57", "ProdottoElett.Sorv 55", "bla bla bla...", false,114));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV58", "ProdottoElett.Sorv 56", "bla bla bla...", false,80));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV59", "ProdottoElett.Sorv 57", "bla bla bla...", false,179));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV60", "ProdottoElett.Sorv 58", "bla bla bla...", false,166));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV61", "ProdottoElett.Sorv 59", "bla bla bla...", false,115));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV62", "ProdottoElett.Sorv 60", "bla bla bla...", false,62));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV63", "ProdottoElett.Sorv 61", "bla bla bla...", false,138));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV64", "ProdottoElett.Sorv 62", "bla bla bla...", false,148));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV65", "ProdottoElett.Sorv 63", "bla bla bla...", false,86));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV66", "ProdottoElett.Sorv 64", "bla bla bla...", false,102));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV67", "ProdottoElett.Sorv 65", "bla bla bla...", false,176));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV68", "ProdottoElett.Sorv 66", "bla bla bla...", false,129));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV69", "ProdottoElett.Sorv 67", "bla bla bla...", false,139));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV70", "ProdottoElett.Sorv 68", "bla bla bla...", false,121));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV71", "ProdottoElett.Sorv 69", "bla bla bla...", false,51));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV72", "ProdottoElett.Sorv 70", "bla bla bla...", false,84));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV73", "ProdottoElett.Sorv 71", "bla bla bla...", false,121));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV74", "ProdottoElett.Sorv 72", "bla bla bla...", false,52));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV75", "ProdottoElett.Sorv 73", "bla bla bla...", false,60));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV76", "ProdottoElett.Sorv 74", "bla bla bla...", false,178));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV77", "ProdottoElett.Sorv 75", "bla bla bla...", false,113));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV78", "ProdottoElett.Sorv 76", "bla bla bla...", false,164));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV79", "ProdottoElett.Sorv 77", "bla bla bla...", false,43));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV80", "ProdottoElett.Sorv 78", "bla bla bla...", false,160));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV81", "ProdottoElett.Sorv 79", "bla bla bla...", false,137));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV82", "ProdottoElett.Sorv 80", "bla bla bla...", false,104));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV83", "ProdottoElett.Sorv 81", "bla bla bla...", false,132));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV84", "ProdottoElett.Sorv 82", "bla bla bla...", false,176));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV85", "ProdottoElett.Sorv 83", "bla bla bla...", false,168));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV86", "ProdottoElett.Sorv 84", "bla bla bla...", false,40));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV87", "ProdottoElett.Sorv 85", "bla bla bla...", false,37));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV88", "ProdottoElett.Sorv 86", "bla bla bla...", false,95));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV89", "ProdottoElett.Sorv 87", "bla bla bla...", false,151));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV90", "ProdottoElett.Sorv 88", "bla bla bla...", false,123));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV91", "ProdottoElett.Sorv 89", "bla bla bla...", false,147));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV92", "ProdottoElett.Sorv 90", "bla bla bla...", false,44));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV93", "ProdottoElett.Sorv 91", "bla bla bla...", false,130));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV94", "ProdottoElett.Sorv 92", "bla bla bla...", false,121));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV95", "ProdottoElett.Sorv 93", "bla bla bla...", false,120));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV96", "ProdottoElett.Sorv 94", "bla bla bla...", false,87));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV97", "ProdottoElett.Sorv 95", "bla bla bla...", false,122));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV98", "ProdottoElett.Sorv 96", "bla bla bla...", false,33));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV99", "ProdottoElett.Sorv 97", "bla bla bla...", false,111));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV100", "ProdottoElett.Sorv 98", "bla bla bla...", false,151));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV101", "ProdottoElett.Sorv 99", "bla bla bla...", false,69));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Sorveglianza, Tipo.Prodotto, "SORV102", "ProdottoElett.Sorv 100", "bla bla bla...", false,95));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW3", "ProdottoElett.Hardware 1", "bla bla bla...", false,98));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW4", "ProdottoElett.Hardware 2", "bla bla bla...", false,163));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW5", "ProdottoElett.Hardware 3", "bla bla bla...", false,167));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW6", "ProdottoElett.Hardware 4", "bla bla bla...", false,33));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW7", "ProdottoElett.Hardware 5", "bla bla bla...", false,112));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW8", "ProdottoElett.Hardware 6", "bla bla bla...", false,89));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW9", "ProdottoElett.Hardware 7", "bla bla bla...", false,49));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW10", "ProdottoElett.Hardware 8", "bla bla bla...", false,91));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW11", "ProdottoElett.Hardware 9", "bla bla bla...", false,73));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW12", "ProdottoElett.Hardware 10", "bla bla bla...", false,40));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW13", "ProdottoElett.Hardware 11", "bla bla bla...", false,171));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW14", "ProdottoElett.Hardware 12", "bla bla bla...", false,150));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW15", "ProdottoElett.Hardware 13", "bla bla bla...", false,161));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW16", "ProdottoElett.Hardware 14", "bla bla bla...", false,88));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW17", "ProdottoElett.Hardware 15", "bla bla bla...", false,69));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW18", "ProdottoElett.Hardware 16", "bla bla bla...", false,174));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW19", "ProdottoElett.Hardware 17", "bla bla bla...", false,179));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW20", "ProdottoElett.Hardware 18", "bla bla bla...", false,167));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW21", "ProdottoElett.Hardware 19", "bla bla bla...", false,66));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW22", "ProdottoElett.Hardware 20", "bla bla bla...", false,94));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW23", "ProdottoElett.Hardware 21", "bla bla bla...", false,137));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW24", "ProdottoElett.Hardware 22", "bla bla bla...", false,64));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW25", "ProdottoElett.Hardware 23", "bla bla bla...", false,104));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW26", "ProdottoElett.Hardware 24", "bla bla bla...", false,68));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW27", "ProdottoElett.Hardware 25", "bla bla bla...", false,135));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW28", "ProdottoElett.Hardware 26", "bla bla bla...", false,138));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW29", "ProdottoElett.Hardware 27", "bla bla bla...", false,115));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW30", "ProdottoElett.Hardware 28", "bla bla bla...", false,89));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW31", "ProdottoElett.Hardware 29", "bla bla bla...", false,30));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW32", "ProdottoElett.Hardware 30", "bla bla bla...", false,108));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW33", "ProdottoElett.Hardware 31", "bla bla bla...", false,37));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW34", "ProdottoElett.Hardware 32", "bla bla bla...", false,91));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW35", "ProdottoElett.Hardware 33", "bla bla bla...", false,61));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW36", "ProdottoElett.Hardware 34", "bla bla bla...", false,88));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW37", "ProdottoElett.Hardware 35", "bla bla bla...", false,53));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW38", "ProdottoElett.Hardware 36", "bla bla bla...", false,70));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW39", "ProdottoElett.Hardware 37", "bla bla bla...", false,135));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW40", "ProdottoElett.Hardware 38", "bla bla bla...", false,100));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW41", "ProdottoElett.Hardware 39", "bla bla bla...", false,142));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW42", "ProdottoElett.Hardware 40", "bla bla bla...", false,78));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW43", "ProdottoElett.Hardware 41", "bla bla bla...", false,66));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW44", "ProdottoElett.Hardware 42", "bla bla bla...", false,43));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW45", "ProdottoElett.Hardware 43", "bla bla bla...", false,37));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW46", "ProdottoElett.Hardware 44", "bla bla bla...", false,149));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW47", "ProdottoElett.Hardware 45", "bla bla bla...", false,57));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW48", "ProdottoElett.Hardware 46", "bla bla bla...", false,31));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW49", "ProdottoElett.Hardware 47", "bla bla bla...", false,110));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW50", "ProdottoElett.Hardware 48", "bla bla bla...", false,69));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW51", "ProdottoElett.Hardware 49", "bla bla bla...", false,35));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW52", "ProdottoElett.Hardware 50", "bla bla bla...", false,169));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW53", "ProdottoElett.Hardware 51", "bla bla bla...", false,258));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW54", "ProdottoElett.Hardware 52", "bla bla bla...", false,43));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW55", "ProdottoElett.Hardware 53", "bla bla bla...", false,54));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW56", "ProdottoElett.Hardware 54", "bla bla bla...", false,555));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW57", "ProdottoElett.Hardware 55", "bla bla bla...", false,123));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW58", "ProdottoElett.Hardware 56", "bla bla bla...", false,141));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW59", "ProdottoElett.Hardware 57", "bla bla bla...", false,151));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW60", "ProdottoElett.Hardware 58", "bla bla bla...", false,173));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW61", "ProdottoElett.Hardware 59", "bla bla bla...", false,104));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW62", "ProdottoElett.Hardware 60", "bla bla bla...", false,83));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW63", "ProdottoElett.Hardware 61", "bla bla bla...", false,148));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW64", "ProdottoElett.Hardware 62", "bla bla bla...", false,83));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW65", "ProdottoElett.Hardware 63", "bla bla bla...", false,168));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW66", "ProdottoElett.Hardware 64", "bla bla bla...", false,57));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW67", "ProdottoElett.Hardware 65", "bla bla bla...", false,110));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW68", "ProdottoElett.Hardware 66", "bla bla bla...", false,46));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW69", "ProdottoElett.Hardware 67", "bla bla bla...", false,89));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW70", "ProdottoElett.Hardware 68", "bla bla bla...", false,121));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW71", "ProdottoElett.Hardware 69", "bla bla bla...", false,73));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW72", "ProdottoElett.Hardware 70", "bla bla bla...", false,141));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW73", "ProdottoElett.Hardware 71", "bla bla bla...", false,56));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW74", "ProdottoElett.Hardware 72", "bla bla bla...", false,164));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW75", "ProdottoElett.Hardware 73", "bla bla bla...", false,124));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW76", "ProdottoElett.Hardware 74", "bla bla bla...", false,114));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW77", "ProdottoElett.Hardware 75", "bla bla bla...", false,136));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW78", "ProdottoElett.Hardware 76", "bla bla bla...", false,175));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW79", "ProdottoElett.Hardware 77", "bla bla bla...", false,138));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW80", "ProdottoElett.Hardware 78", "bla bla bla...", false,135));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW81", "ProdottoElett.Hardware 79", "bla bla bla...", false,80));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW82", "ProdottoElett.Hardware 80", "bla bla bla...", false,143));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW83", "ProdottoElett.Hardware 81", "bla bla bla...", false,163));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW84", "ProdottoElett.Hardware 82", "bla bla bla...", false,176));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW85", "ProdottoElett.Hardware 83", "bla bla bla...", false,171));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW86", "ProdottoElett.Hardware 84", "bla bla bla...", false,175));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW87", "ProdottoElett.Hardware 85", "bla bla bla...", false,83));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW88", "ProdottoElett.Hardware 86", "bla bla bla...", false,82));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW89", "ProdottoElett.Hardware 87", "bla bla bla...", false,123));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW90", "ProdottoElett.Hardware 88", "bla bla bla...", false,74));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW91", "ProdottoElett.Hardware 89", "bla bla bla...", false,87));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW92", "ProdottoElett.Hardware 90", "bla bla bla...", false,60));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW93", "ProdottoElett.Hardware 91", "bla bla bla...", false,119));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW94", "ProdottoElett.Hardware 92", "bla bla bla...", false,94));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW95", "ProdottoElett.Hardware 93", "bla bla bla...", false,43));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW96", "ProdottoElett.Hardware 94", "bla bla bla...", false,179));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW97", "ProdottoElett.Hardware 95", "bla bla bla...", false,156));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW98", "ProdottoElett.Hardware 96", "bla bla bla...", false,95));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW99", "ProdottoElett.Hardware 97", "bla bla bla...", false,123));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW100", "ProdottoElett.Hardware 98", "bla bla bla...", false,151));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW101", "ProdottoElett.Hardware 99", "bla bla bla...", false,174));
		elencoProdotti.add(new Prodotto(Categoria.Elettronica, SottoCategoria.Hardware, Tipo.Prodotto, "HARDW102", "ProdottoElett.Hardware 100", "bla bla bla...", false,74));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Software, Tipo.Prodotto, "SOFTW3", "ProdottoInfo.Software 1", "bla bla bla...", false,100));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Software, Tipo.Prodotto, "SOFTW4", "ProdottoInfo.Software 2", "bla bla bla...", false,163));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Software, Tipo.Prodotto, "SOFTW5", "ProdottoInfo.Software 3", "bla bla bla...", false,92));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Software, Tipo.Prodotto, "SOFTW6", "ProdottoInfo.Software 4", "bla bla bla...", false,155));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Software, Tipo.Prodotto, "SOFTW7", "ProdottoInfo.Software 5", "bla bla bla...", false,49));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Software, Tipo.Prodotto, "SOFTW8", "ProdottoInfo.Software 6", "bla bla bla...", false,60));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Software, Tipo.Prodotto, "SOFTW9", "ProdottoInfo.Software 7", "bla bla bla...", false,137));
		elencoProdotti.add(new Prodotto(Categoria.Informatica, SottoCategoria.Sicurezza, Tipo.Prodotto, "SICUR102", "ProdottoInfo.Software 100", "bla bla bla...", false,154));		
	}

	@Override
	public Prodotto searchProdotto(String codice) throws ProdottoInesistente{
		for (Prodotto prodotto : elencoProdotti) {
			if(prodotto.getCodice().equals(codice)) return prodotto;
		}
		throw new ProdottoInesistente(codice);
	}
	
	
	@Override
	public ArrayList<Prodotto> elencoProdotti() {
		return elencoProdotti;
	}

	@Override
	public Date dataDisponiblita(String codiceProdotto) {
		return new Date();
	}

	
	
}
