package tc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

public class Calcolatore {

	
	private void init() {
		iMaxLivello=22;

		minAgilita=10;
		minResistenza=1;
		minServizio=1;
		minVolley=-1;
		minDiritto=10;
		minRovescio=10;

//		personaggiAmmessi=Arrays.asList(EnumPersonaggi.Abeke);
//		allenamentiAmmessi=Arrays.asList(EnumAllenamento.Fascia_di_resistenza);
//		gripAmmessi=Arrays.asList(EnumGrip.Il_machete);
//		nutrizioniAmmesse=Arrays.asList(EnumNutrizione.Carico_di_carboidrati);
//		polsiniAmmessi=Arrays.asList(EnumPolsino.Il_razzo);
//		racchetteAmmesse=Arrays.asList(EnumRacchette.La_pantera);
//		scarpeAmmesse=Arrays.asList(EnumScarpe.L_incudine);

//		personaggiEsclusi=Arrays.asList(EnumPersonaggi.Kaito, EnumPersonaggi.Omar, EnumPersonaggi.Abeke
//				, EnumPersonaggi.Anton, EnumPersonaggi.Diana, EnumPersonaggi.Florence, EnumPersonaggi.Hope, EnumPersonaggi.Jonah
//				, EnumPersonaggi.Leo, EnumPersonaggi.Victoria, EnumPersonaggi.Luc, EnumPersonaggi.Mei_Li );
//		allenamentiEsclusi=Arrays.asList(EnumAllenamento.Fascia_di_resistenza);
//		gripEsclusi=Arrays.asList(EnumGrip.Il_machete);
//		nutrizioniEscluse=Arrays.asList(EnumNutrizione.Carico_di_carboidrati);
//		polsiniEsclusi=Arrays.asList(EnumPolsino.Il_razzo);
//		racchetteEscluse=Arrays.asList(EnumRacchette.Il_martello);
//		scarpeEscluse=Arrays.asList(EnumScarpe.L_incudine);
		
		
		livelliCarte.put(EnumPersonaggi.Jonah, 11);
		livelliCarte.put(EnumPersonaggi.Hope, 11);
		livelliCarte.put(EnumPersonaggi.Florence, 11);
		livelliCarte.put(EnumPersonaggi.Leo, 11);
		livelliCarte.put(EnumPersonaggi.Kaito, 11);
		livelliCarte.put(EnumPersonaggi.Anton, 3);
		livelliCarte.put(EnumPersonaggi.Victoria, 11);
		livelliCarte.put(EnumPersonaggi.Omar, 8);
		livelliCarte.put(EnumPersonaggi.Diana, 9);
		livelliCarte.put(EnumPersonaggi.Abeke, 8);
		livelliCarte.put(EnumPersonaggi.Mei_Li, 8);
		livelliCarte.put(EnumPersonaggi.Luc, 6);
		
		livelliCarte.put(EnumRacchette.L_aquila,11);
		livelliCarte.put(EnumRacchette.Il_patriota,10);
		livelliCarte.put(EnumRacchette.L_entroterra,9);
		livelliCarte.put(EnumRacchette.La_pantera,11);
		livelliCarte.put(EnumRacchette.Il_samurai,13);
		livelliCarte.put(EnumRacchette.Il_martello,11);
		livelliCarte.put(EnumRacchette.Bersaglio,10);
		livelliCarte.put(EnumRacchette.Zeus,12);
		
		livelliCarte.put(EnumGrip.Il_guerriero,11);
		livelliCarte.put(EnumGrip.L_artiglio,9);
		livelliCarte.put(EnumGrip.Il_machete,11);
		livelliCarte.put(EnumGrip.Il_cobra,9);
		livelliCarte.put(EnumGrip.La_katana,13);
		livelliCarte.put(EnumGrip.La_fucina,10);
		livelliCarte.put(EnumGrip.Grip_tattico,13);
		livelliCarte.put(EnumGrip.Iltitano,8);

		livelliCarte.put(EnumScarpe.La_piuma,9);
		livelliCarte.put(EnumScarpe.Il_rapace,11);
		livelliCarte.put(EnumScarpe.Il_cacciatore,11);
		livelliCarte.put(EnumScarpe.Il_piragna,9);
		livelliCarte.put(EnumScarpe.La_shuriken,10);
		livelliCarte.put(EnumScarpe.L_incudine,13);
		livelliCarte.put(EnumScarpe.La_balistica,11);
		livelliCarte.put(EnumScarpe.PercorsiDiAde,6);
		
		livelliCarte.put(EnumPolsino.Il_Tomahawk,9);		
		livelliCarte.put(EnumPolsino.Il_razzo,11);		
		livelliCarte.put(EnumPolsino.Bandiera_pirata,9);		
		livelliCarte.put(EnumPolsino.Il_pappagallo_ara,11);		
		livelliCarte.put(EnumPolsino.Il_koi,10);		
		livelliCarte.put(EnumPolsino.L_orso_Kodiac,13);		
		livelliCarte.put(EnumPolsino.Il_gladiatore,8);		
		livelliCarte.put(EnumPolsino.Lo_scudo,9);		
		
		livelliCarte.put(EnumNutrizione.Proteina_magra,9);		
		livelliCarte.put(EnumNutrizione.Idratazione_aumentata,11);		
		livelliCarte.put(EnumNutrizione.Macrobiotico,9);		
		livelliCarte.put(EnumNutrizione.Dieta_vegana,11);		
		livelliCarte.put(EnumNutrizione.Dieta_keto,11);		
		livelliCarte.put(EnumNutrizione.Antiossidanti,14);		
		livelliCarte.put(EnumNutrizione.Carico_di_carboidrati,10);		
		livelliCarte.put(EnumNutrizione.Neutral_energy,9);		

		livelliCarte.put(EnumAllenamento.Resistenza,11);
		livelliCarte.put(EnumAllenamento.Sprint,9);
		livelliCarte.put(EnumAllenamento.Pilometria,11);
		livelliCarte.put(EnumAllenamento.Powerlifting,9);
		livelliCarte.put(EnumAllenamento.Sollevamento_pesi,14);
		livelliCarte.put(EnumAllenamento.Fascia_di_resistenza,9);
		livelliCarte.put(EnumAllenamento.Arrampicatore,11);
		livelliCarte.put(EnumAllenamento.Affondi,7);
		
	}

	public  static void main(String[] args) throws Exception {
		Calcolatore c = new Calcolatore();
		c.go();
		System.out.println();
	}

	private void go() throws Exception {
		disabilitaCertificati();
		for (EnumTipoScelta categoria : EnumTipoScelta.values()) {
			navigaCategoria(categoria.getNome());
		}
		System.out.println(tipiScelte);
		init();
		/*
			creaPersonaggi();
			creaRacchette();
			creaGrip();
			creaScarpe();
			creaPolsino();
			creaNutrizione();
			creaAllenamento();
			*/
		calcola();
	}



	private void calcola() {

		List<TipoScelta> personaggi = tipiScelte.get(EnumTipoScelta.Personaggio);
		List<TipoScelta> racchette = tipiScelte.get(EnumTipoScelta.Racchetta);
		List<TipoScelta> grips = tipiScelte.get(EnumTipoScelta.Grip);
		List<TipoScelta> scarpe = tipiScelte.get(EnumTipoScelta.Scarpa);
		List<TipoScelta> polsini = tipiScelte.get(EnumTipoScelta.Polsino);
		List<TipoScelta> nutrizioni = tipiScelte.get(EnumTipoScelta.Nutrizione);
		List<TipoScelta> allenamenti = tipiScelte.get(EnumTipoScelta.Allenamento);
		Multimap<Integer, Esito> retTipoScelta = TreeMultimap.create();
		for (TipoScelta personaggio : personaggi) {
			for (TipoScelta racchetta : racchette) {
				for (TipoScelta grip : grips) {
					for (TipoScelta scarpa : scarpe) {
						for (TipoScelta polsino : polsini) {
							for (TipoScelta nutrizione : nutrizioni) {
								for (TipoScelta allenamento : allenamenti) {
									
									if (personaggiAmmessi != null &&  !personaggiAmmessi.contains(personaggio.getOggetto())) continue;
									if (gripAmmessi != null &&  !gripAmmessi.contains(grip.getOggetto())) continue;
									if (allenamentiAmmessi != null &&  !allenamentiAmmessi.contains(allenamento.getOggetto())) continue;
									if (nutrizioniAmmesse != null &&  !nutrizioniAmmesse.contains(nutrizione.getOggetto())) continue;
									if (polsiniAmmessi != null &&  !polsiniAmmessi.contains(polsino.getOggetto())) continue;
									if (racchetteAmmesse != null &&  !racchetteAmmesse.contains(racchetta.getOggetto())) continue;
									if (scarpeAmmesse != null &&  !scarpeAmmesse.contains(scarpa.getOggetto())) continue;
									
									if (personaggiEsclusi != null &&  personaggiEsclusi.contains(personaggio.getOggetto())) continue;
									if (gripEsclusi != null &&  gripEsclusi.contains(grip.getOggetto())) continue;
									if (allenamentiEsclusi != null &&  allenamentiEsclusi.contains(allenamento.getOggetto())) continue;
									if (nutrizioniEscluse != null &&  nutrizioniEscluse.contains(nutrizione.getOggetto())) continue;
									if (polsiniEsclusi != null &&  polsiniEsclusi.contains(polsino.getOggetto())) continue;
									if (racchetteEscluse != null &&  racchetteEscluse.contains(racchetta.getOggetto())) continue;
									if (scarpeEscluse != null &&  scarpeEscluse.contains(scarpa.getOggetto())) continue;
									
									Map<String,Object> caratteristichePersonaggio = getMaxCaratteristiche(personaggio.getCaratteristiche(),personaggio.getOggetto());
									Map<String,Object> caratteristicheRacchetta = getMaxCaratteristiche(racchetta.getCaratteristiche(),racchetta.getOggetto());
									Map<String,Object> caratteristicheGrip = getMaxCaratteristiche(grip.getCaratteristiche(),grip.getOggetto());
									Map<String,Object> caratteristicheScarpa = getMaxCaratteristiche(scarpa.getCaratteristiche(),scarpa.getOggetto());
									Map<String,Object> caratteristichePolsino = getMaxCaratteristiche(polsino.getCaratteristiche(),polsino.getOggetto());
									Map<String,Object> caratteristicheNutrizione = getMaxCaratteristiche(nutrizione.getCaratteristiche(),nutrizione.getOggetto());
									Map<String,Object> caratteristicheAllenamento = getMaxCaratteristiche(allenamento.getCaratteristiche(),allenamento.getOggetto());

									if (caratteristichePersonaggio == null) continue;
									if (caratteristicheRacchetta == null) continue;
									if (caratteristicheGrip == null) continue;
									if (caratteristicheScarpa == null) continue;
									if (caratteristichePolsino == null) continue;
									if (caratteristicheNutrizione == null) continue;
									if (caratteristicheAllenamento == null) continue;
									
									int iAgilita=0;
									int iResistenza=0;
									int iServizio=0;
									int iVolley=0;
									int iDiritto=0;
									int iRovescio=0;


									if (((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Agilita)!=null) iAgilita = iAgilita + (Integer) ((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Agilita);
									if (((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Resistenza)!=null) iResistenza = iResistenza +  (Integer) ((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Resistenza);
									if (((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Servizio)!=null) iServizio = iServizio + (Integer)  ((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Servizio);
									if (((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Volley)!=null) iVolley = iVolley +  (Integer) ((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Volley);
									if (((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Diritto)!=null) iDiritto = iDiritto +  (Integer) ((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Diritto);
									if (((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Rovescio)!=null) iRovescio = iRovescio + (Integer)  ((Map)caratteristichePersonaggio.get("attuale")).get(EnumAbilita.Rovescio);

									if (((Map)caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Agilita)!=null) iAgilita = iAgilita + (Integer) ((Map)caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Agilita);
									if (((Map)caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Resistenza)!=null) iResistenza = iResistenza  + (Integer) ((Map) caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Resistenza);
									if (((Map)caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Servizio)!=null) iServizio = iServizio  + (Integer) ((Map) caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Servizio);
									if (((Map)caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Volley)!=null) iVolley = iVolley  + (Integer) ((Map) caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Volley);
									if (((Map)caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Diritto)!=null) iDiritto = iDiritto  + (Integer) ((Map) caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Diritto);
									if (((Map)caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Rovescio)!=null) iRovescio = iRovescio  + (Integer) ((Map) caratteristicheRacchetta.get("attuale")).get(EnumAbilita.Rovescio);

									if (((Map)caratteristicheGrip.get("attuale")).get(EnumAbilita.Agilita)!=null) iAgilita = iAgilita  + (Integer) ((Map) caratteristicheGrip.get("attuale")).get(EnumAbilita.Agilita);
									if (((Map)caratteristicheGrip.get("attuale")).get(EnumAbilita.Resistenza)!=null) iResistenza = iResistenza  + (Integer) ((Map) caratteristicheGrip.get("attuale")).get(EnumAbilita.Resistenza);
									if (((Map)caratteristicheGrip.get("attuale")).get(EnumAbilita.Servizio)!=null) iServizio = iServizio  + (Integer) ((Map) caratteristicheGrip.get("attuale")).get(EnumAbilita.Servizio);
									if (((Map)caratteristicheGrip.get("attuale")).get(EnumAbilita.Volley)!=null) iVolley = iVolley  + (Integer) ((Map) caratteristicheGrip.get("attuale")).get(EnumAbilita.Volley);
									if (((Map)caratteristicheGrip.get("attuale")).get(EnumAbilita.Diritto)!=null) iDiritto = iDiritto  + (Integer) ((Map) caratteristicheGrip.get("attuale")).get(EnumAbilita.Diritto);
									if (((Map)caratteristicheGrip.get("attuale")).get(EnumAbilita.Rovescio)!=null) iRovescio = iRovescio  + (Integer) ((Map) caratteristicheGrip.get("attuale")).get(EnumAbilita.Rovescio);

									if (((Map)caratteristicheScarpa.get("attuale")).get(EnumAbilita.Agilita)!=null) iAgilita = iAgilita  + (Integer) ((Map) caratteristicheScarpa.get("attuale")).get(EnumAbilita.Agilita);
									if (((Map)caratteristicheScarpa.get("attuale")).get(EnumAbilita.Resistenza)!=null) iResistenza = iResistenza  + (Integer) ((Map) caratteristicheScarpa.get("attuale")).get(EnumAbilita.Resistenza);
									if (((Map)caratteristicheScarpa.get("attuale")).get(EnumAbilita.Servizio)!=null) iServizio = iServizio  + (Integer) ((Map) caratteristicheScarpa.get("attuale")).get(EnumAbilita.Servizio);
									if (((Map)caratteristicheScarpa.get("attuale")).get(EnumAbilita.Volley)!=null) iVolley = iVolley  + (Integer) ((Map) caratteristicheScarpa.get("attuale")).get(EnumAbilita.Volley);
									if (((Map)caratteristicheScarpa.get("attuale")).get(EnumAbilita.Diritto)!=null) iDiritto = iDiritto  + (Integer) ((Map) caratteristicheScarpa.get("attuale")).get(EnumAbilita.Diritto);
									if (((Map)caratteristicheScarpa.get("attuale")).get(EnumAbilita.Rovescio)!=null) iRovescio = iRovescio  + (Integer) ((Map) caratteristicheScarpa.get("attuale")).get(EnumAbilita.Rovescio);

									if (((Map)caratteristichePolsino.get("attuale")).get(EnumAbilita.Agilita)!=null) iAgilita = iAgilita  + (Integer) ((Map) caratteristichePolsino.get("attuale")).get(EnumAbilita.Agilita);
									if (((Map)caratteristichePolsino.get("attuale")).get(EnumAbilita.Resistenza)!=null) iResistenza = iResistenza  + (Integer) ((Map) caratteristichePolsino.get("attuale")).get(EnumAbilita.Resistenza);
									if (((Map)caratteristichePolsino.get("attuale")).get(EnumAbilita.Servizio)!=null) iServizio = iServizio  + (Integer) ((Map) caratteristichePolsino.get("attuale")).get(EnumAbilita.Servizio);
									if (((Map)caratteristichePolsino.get("attuale")).get(EnumAbilita.Volley)!=null) iVolley = iVolley  + (Integer) ((Map) caratteristichePolsino.get("attuale")).get(EnumAbilita.Volley);
									if (((Map)caratteristichePolsino.get("attuale")).get(EnumAbilita.Diritto)!=null) iDiritto = iDiritto  + (Integer) ((Map) caratteristichePolsino.get("attuale")).get(EnumAbilita.Diritto);
									if (((Map)caratteristichePolsino.get("attuale")).get(EnumAbilita.Rovescio)!=null) iRovescio = iRovescio  + (Integer) ((Map) caratteristichePolsino.get("attuale")).get(EnumAbilita.Rovescio);

									if (((Map)caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Agilita)!=null) iAgilita = iAgilita  + (Integer) ((Map) caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Agilita);
									if (((Map)caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Resistenza)!=null) iResistenza = iResistenza  + (Integer) ((Map) caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Resistenza);
									if (((Map)caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Servizio)!=null) iServizio = iServizio  + (Integer) ((Map) caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Servizio);
									if (((Map)caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Volley)!=null) iVolley = iVolley  + (Integer) ((Map) caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Volley);
									if (((Map)caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Diritto)!=null) iDiritto = iDiritto  + (Integer) ((Map) caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Diritto);
									if (((Map)caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Rovescio)!=null) iRovescio = iRovescio  + (Integer) ((Map) caratteristicheNutrizione.get("attuale")).get(EnumAbilita.Rovescio);

									if (((Map)caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Agilita)!=null) iAgilita = iAgilita  + (Integer) ((Map) caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Agilita);
									if (((Map)caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Resistenza)!=null) iResistenza = iResistenza  + (Integer) ((Map) caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Resistenza);
									if (((Map)caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Servizio)!=null) iServizio = iServizio  + (Integer) ((Map) caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Servizio);
									if (((Map)caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Volley)!=null) iVolley = iVolley  + (Integer) ((Map) caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Volley);
									if (((Map)caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Diritto)!=null) iDiritto = iDiritto  + (Integer) ((Map) caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Diritto);
									if (((Map)caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Rovescio)!=null) iRovescio = iRovescio  + (Integer) ((Map) caratteristicheAllenamento.get("attuale")).get(EnumAbilita.Rovescio);

									if (iAgilita>=minAgilita && iResistenza >= minResistenza && iServizio >= minServizio && iVolley >= minVolley && iDiritto >= minDiritto && iRovescio >= minRovescio) {
										Integer key = 0;
										if (minAgilita>0) key=key+iAgilita;
										if (minResistenza>0) key=key+iResistenza;
										if (minServizio>0) key=key+iServizio;
										if (minVolley>0) key=key+iVolley;
										if (minDiritto>0) key=key+iDiritto;
										if (minRovescio>0) key=key+iRovescio;
										
										Esito esito = new Esito(key);
										esito.aggiungiCaratteristiche(caratteristichePersonaggio).aggiungiCaratteristiche(caratteristicheRacchetta).aggiungiCaratteristiche(caratteristicheGrip).aggiungiCaratteristiche(caratteristicheScarpa).aggiungiCaratteristiche(caratteristichePolsino).aggiungiCaratteristiche(caratteristicheNutrizione).aggiungiCaratteristiche(caratteristicheAllenamento);
										esito.aggiungiOggetto(personaggio.getOggetto()).aggiungiOggetto(racchetta.getOggetto()).aggiungiOggetto(grip.getOggetto()).aggiungiOggetto(scarpa.getOggetto()).aggiungiOggetto(polsino.getOggetto()).aggiungiOggetto(nutrizione.getOggetto()).aggiungiOggetto(allenamento.getOggetto());
										esito.aggiungiValori((minAgilita>0?"":"(*)")+"Agilita'",iAgilita).
										aggiungiValori((minResistenza>0?"":"(*)")+"Resistenza",iResistenza).
										aggiungiValori((minServizio>0?"":"(*)")+"Servizio",iServizio).
										aggiungiValori((minVolley>0?"":"(*)")+"Volley",iVolley).
										aggiungiValori((minDiritto>0?"":"(*)")+"Diritto",iDiritto).
										aggiungiValori((minRovescio>0?"":"(*)")+"Rovescio",iRovescio);
										retTipoScelta.put(key, esito);
									}
								}
							}
						}
					}
				}
			}
		}
		Iterator<Integer> iterator = retTipoScelta.keySet().iterator();
		while (iterator.hasNext()) {
			Integer sommaValori = (Integer) iterator.next();
			Collection<Esito> esiti = retTipoScelta.get(sommaValori);
			for (Esito esito : esiti) {
				System.out.println(esito);
			}
		}
	}

	private Map<String,Object> getMaxCaratteristiche(Map<Integer, Map<EnumAbilita, Integer>> caratteristiche, EnumOggetti oggetto) {
		Integer max = livelliCarte.get(oggetto);
		if (max == null) return null;
		if (max > iMaxLivello) max = iMaxLivello;
		
		for (int i=max;i>0;i--) {
			Map<EnumAbilita, Integer> attuale = caratteristiche.get(i);
			if (attuale != null) {
				Map<String, Object> ret = new HashMap();
				ret.put("livello",i);
				ret.put("attuale",attuale);
				return ret; 
			}
		}
		return null;
	}

	Map<EnumTipoScelta,List<TipoScelta>> tipiScelte = new TreeMap();
	Integer minAgilita;
	Integer minResistenza;
	Integer minServizio;
	Integer minVolley;
	Integer minDiritto;
	Integer minRovescio;
	List<EnumPersonaggi> personaggiAmmessi;
	List<EnumAllenamento> allenamentiAmmessi;
	List<EnumGrip> gripAmmessi;
	List<EnumNutrizione> nutrizioniAmmesse;
	List<EnumPolsino> polsiniAmmessi;
	List<EnumRacchette> racchetteAmmesse;
	List<EnumScarpe> scarpeAmmesse;

	List<EnumPersonaggi> personaggiEsclusi;
	List<EnumAllenamento> allenamentiEsclusi;
	List<EnumGrip> gripEsclusi;
	List<EnumNutrizione> nutrizioniEscluse;
	List<EnumPolsino> polsiniEsclusi;
	List<EnumRacchette> racchetteEscluse;
	List<EnumScarpe> scarpeEscluse;
	
	Map<EnumOggetti,Integer> livelliCarte=new HashMap();
	Integer iMaxLivello;
	private  final String HTTPS_TENNIS_CLASH_FANDOM_COM = "https://tennis-clash.fandom.com";

	private  void disabilitaCertificati() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] {
					new X509TrustManager() {
						public X509Certificate[] getAcceptedIssuers() {
							return null;
						}
						public void checkClientTrusted(X509Certificate[] certs, String authType) {
						}
						public void checkServerTrusted(X509Certificate[] certs, String authType) {
						}
					}
			};

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private  String getHTTP(String url, Map<String, String>... headers) throws Exception {
		//		System.out.println("GET " + url + " " + printMap(headers));
		URL obj = new URL(url);
		HttpURLConnection getConnection = (HttpURLConnection) obj.openConnection();
		getConnection.setRequestMethod("GET");
		if (headers!=null && headers.length>0) {
			Iterator<String> iterator = headers[0].keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				getConnection.setRequestProperty(key, headers[0].get(key));
			}
		}
		int responseCode = getConnection.getResponseCode();
		Map<String, List<String>> headerFields = getConnection.getHeaderFields();
		StringBuffer response = new StringBuffer();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(getConnection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} else {
			BufferedReader bfOutputResponse = new BufferedReader(
					new InputStreamReader(getConnection.getErrorStream()));
			String outputLine;
			StringBuffer sfResponse = new StringBuffer();
			while ((outputLine = bfOutputResponse.readLine()) != null) {
				sfResponse.append(outputLine);
			}
			bfOutputResponse.close();
			String stringResponse = sfResponse.toString();
			throw new RuntimeException("GET NOT WORKED ".concat(url).concat(" -> ").concat("STACK:")
					.concat(stringResponse));
		}
		return response.toString(); 
	}
	
	private  void navigaCategoria(String category) throws Exception {
		String http = cachGetHTTP(category + ".json", HTTPS_TENNIS_CLASH_FANDOM_COM + "/wiki/Category:" + category);
		Document doc = Jsoup.parse(http);
		Elements elements = doc.getElementsByClass("category-page__members");
		List<Node> childNodes = elements.get(0).childNodes();
		Set<String> pagine = new HashSet<String>();
		for (Node node : childNodes) {
			if (node instanceof Element) {
				Elements elementsByTag = ((Element) node).getElementsByTag("A");
				for (Element element : elementsByTag) {
					pagine.add(element.attr("href"));
				}
			}
		}
		for (String pagina : pagine) {
			navigaPage(category,pagina);
		}
	}

	private  void navigaPage(String category, String page) throws Exception {
		try {
			String obj=page.substring(6);
			String http = cachGetHTTP(obj + ".json",HTTPS_TENNIS_CLASH_FANDOM_COM + page);
			Document doc = Jsoup.parse(http);//, StandardCharsets.UTF_8.toString()
			Elements elements = doc.getElementsByClass("article-table");
			
			List<Node> childNodes = elements.get(1).childNodes().get(0).childNodes();
			Map<Integer, List<Map<String,Integer>>> valori=new HashMap();
			for (int i=1;i<childNodes.size();i++) {
				Node node = childNodes.get(i);
				List<Node> righe = node.childNodes();
				for (int k=1;k<righe.size();k++) {
					String val="0";
					if (righe.get(k).childNodeSize()>0) {
						val = righe.get(k).childNode(0).toString();
					}
					List<Map<String,Integer>>  listaValori = valori.get(k);
					if (listaValori==null) {
						listaValori=new ArrayList();
					}
					Map<String, Integer> valore=new HashMap<String, Integer>();
					valore.put(righe.get(0).childNode(0).toString(), Integer.parseInt(val));
					listaValori.add(valore);
					valori.put(k, listaValori);
//					System.out.println(category + ";" + obj + ";" + righe.get(0).childNode(0) + ";" + k + ";" + Integer.parseInt(val));
				}
			}
//			System.out.println(category + ";" + obj + ";" + valori);

		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		EnumOggetti from = null;
		if (category.equals(EnumTipoScelta.Personaggio.getNome())) {
			from=EnumPersonaggi.from(obj);
		}
		if (category.equals(EnumTipoScelta.Racchetta.getNome())) {
			from=EnumRacchette.from(obj);
		}
		if (category.equals(EnumTipoScelta.Grip.getNome())) {
			from=EnumGrip.from(obj);
		}
		if (category.equals(EnumTipoScelta.Scarpa.getNome())) {
			from=EnumScarpe.from(obj);
		}
		if (category.equals(EnumTipoScelta.Polsino.getNome())) {
			from=EnumPolsino.from(obj);
		}
		if (category.equals(EnumTipoScelta.Nutrizione.getNome())) {
			from=EnumNutrizione.from(obj);
		}
		if (category.equals(EnumTipoScelta.Allenamento.getNome())) {
			from=EnumAllenamento.from(obj);
		}
		List<TipoScelta> tipiScelteTipologia=tipiScelte.get(EnumTipoScelta.from(category));
		if (tipiScelteTipologia==null) {
			tipiScelteTipologia=new ArrayList<TipoScelta>();
		}
		ts = new TipoScelta(EnumTipoScelta.from(category),from);
		for(int i=0;i<valori.size();i++) {
			listaAbilita=new TreeMap<EnumAbilita, Integer>();
			List<Map<String, Integer>> list = valori.get(i+1);
			for (Map<String,Integer> map : list) {
				listaAbilita.put(EnumAbilita.from((String) map.keySet().toArray()[0]),(Integer) map.values().toArray()[0]);
			}
			ts.getCaratteristiche().put(i+1, listaAbilita);
		}
		tipiScelteTipologia.add(ts);

		tipiScelte.put(EnumTipoScelta.from(category), tipiScelteTipologia);

			
		}
		catch (Exception e) {
//			e.printStackTrace(System.out);
//			System.out.println(page);
		}
	}

	private static final String ROOT_FILE = "/1/tc";
	private static final boolean USA_CACHE = true;
	private  ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	
	private  String toJson(Object o) {
		try {
			byte[] data = mapper.writeValueAsBytes(o);
			return new String(data);// , Charsets.ISO_8859_1
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private  Map<String, Object> jsonToMap(String json) {
		try {
			return mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private  String cachGetHTTP(String nomeFile, String url) throws Exception {
		String directory = ROOT_FILE +  "/";
		Path pathFile = Paths.get(directory + nomeFile);
		if (Files.exists(pathFile) && USA_CACHE) {
			try {
				List<String> readAllLines = Files.readAllLines(pathFile, Charset.defaultCharset());
				StringBuilder sb = new StringBuilder();
				for (String linea : readAllLines) {
					sb.append(linea);
				}
				return sb.toString();
			} catch (Exception e)
			{
				e.printStackTrace(System.err);
				throw new RuntimeException("Errore in " + nomeFile);
			}
		} else {
			if (url == null) {
				throw new RuntimeException("File non esistente: " + nomeFile);
			}
			try {
				Path pathDir = Paths.get(directory);
				if (!Files.isDirectory(pathDir))
				{
					Files.createDirectories(pathDir);
				}
				Files.deleteIfExists(pathFile);
				Map<String, String> h=new HashMap();
				//				h.put("Cookie", COOKIE);
				String s = getHTTP(url, h);
				String sPretty="";
				try {
					sPretty = toJson(jsonToMap(s));
				}
				catch(Exception e ) {
					try {
						sPretty = toJson(jsonToList(s));
					}
					catch(Exception e2 ) {
						sPretty=s;
					}
				}
				Files.createFile(pathFile);
				Files.write(pathFile, sPretty.getBytes());
				return s;
			} catch (Exception e)
			{
				e.printStackTrace(System.err);
				throw new RuntimeException("Errore in " + url);
			}
		}
	}
	private  List<Map<String, Object>> jsonToList(String json) {
		try {
			return mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}


