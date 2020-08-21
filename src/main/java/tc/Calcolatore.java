package tc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

public class Calcolatore {

	
	private void init() {
		iMaxLivello=11;

		minAgilita=67;
		minResistenza=29;
		minServizio=26;
		minVolley=-1;
		minDiritto=56;
		minRovescio=53;

//		personaggiAmmessi=Arrays.asList(EnumPersonaggi.Jonah);
//		allenamentiAmmessi=Arrays.asList(EnumAllenamento.Fascia_di_resistenza);
//		gripAmmessi=Arrays.asList(EnumGrip.Il_machete);
//		nutrizioniAmmesse=Arrays.asList(EnumNutrizione.Carico_di_carboidrati);
//		polsiniAmmessi=Arrays.asList(EnumPolsino.Il_razzo);
//		racchetteAmmesse=Arrays.asList(EnumRacchette.La_pantera);
//		scarpeAmmesse=Arrays.asList(EnumScarpe.L_incudine);
		
		
		livelliCarte.put(EnumPersonaggi.Jonah, 9);
		livelliCarte.put(EnumPersonaggi.Hope, 9);
		livelliCarte.put(EnumPersonaggi.Florence, 9);
		livelliCarte.put(EnumPersonaggi.Leo, 8);
		livelliCarte.put(EnumPersonaggi.Kaito, 8);
		livelliCarte.put(EnumPersonaggi.Victoria, 9);
		livelliCarte.put(EnumPersonaggi.Diana, 8);
		livelliCarte.put(EnumPersonaggi.Mei_Li, 4);
		
		livelliCarte.put(EnumRacchette.L_aquila,11);
		livelliCarte.put(EnumRacchette.Il_patriota,8);
		livelliCarte.put(EnumRacchette.L_entroterra,8);
		livelliCarte.put(EnumRacchette.La_pantera,10);
		livelliCarte.put(EnumRacchette.Il_samurai,11);
		livelliCarte.put(EnumRacchette.Il_martello,9);
		
		livelliCarte.put(EnumGrip.Il_guerriero,11);
		livelliCarte.put(EnumGrip.L_artiglio,8);
		livelliCarte.put(EnumGrip.Il_machete,10);
		livelliCarte.put(EnumGrip.Il_cobra,7);
		livelliCarte.put(EnumGrip.La_katana,11);
		livelliCarte.put(EnumGrip.La_fucina,8);
		livelliCarte.put(EnumGrip.Grip_tattico,6);

		livelliCarte.put(EnumScarpe.La_piuma,8);
		livelliCarte.put(EnumScarpe.Il_rapace,11);
		livelliCarte.put(EnumScarpe.Il_cacciatore,11);
		livelliCarte.put(EnumScarpe.Il_piragna,8);
		livelliCarte.put(EnumScarpe.La_shuriken,8);
		livelliCarte.put(EnumScarpe.L_incudine,11);
		livelliCarte.put(EnumScarpe.La_balistica,3);
		
		livelliCarte.put(EnumPolsino.Il_Tomahawk,8);		
		livelliCarte.put(EnumPolsino.Il_razzo,11);		
		livelliCarte.put(EnumPolsino.Bandiera_pirata,8);		
		livelliCarte.put(EnumPolsino.Il_pappagallo_ara,7);		
		livelliCarte.put(EnumPolsino.Il_koi,8);		
		livelliCarte.put(EnumPolsino.L_orso_Kodiac,6);		
		livelliCarte.put(EnumPolsino.Il_gladiatore,4);		
		
		livelliCarte.put(EnumNutrizione.Proteina_magra,8);		
		livelliCarte.put(EnumNutrizione.Idratazione_aumentata,11);		
		livelliCarte.put(EnumNutrizione.Macrobiotico,8);		
		livelliCarte.put(EnumNutrizione.Dieta_vegana,9);		
		livelliCarte.put(EnumNutrizione.Dieta_keto,8);		
		livelliCarte.put(EnumNutrizione.Antiossidanti,12);		
		livelliCarte.put(EnumNutrizione.Carico_di_carboidrati,7);		

		livelliCarte.put(EnumAllenamento.Resistenza,11);
		livelliCarte.put(EnumAllenamento.Sprint,8);
		livelliCarte.put(EnumAllenamento.Pilometria,11);
		livelliCarte.put(EnumAllenamento.Powerlifting,7);
		livelliCarte.put(EnumAllenamento.Sollevamento_pesi,12);
		livelliCarte.put(EnumAllenamento.Fascia_di_resistenza,7);
		livelliCarte.put(EnumAllenamento.Arrampicatore,5);
		
	}

	public static void main(String[] args) {
		Calcolatore c = new Calcolatore();
		c.go();
		System.out.println();
	}

	private void go() {
		init();
			creaPersonaggi();
			creaRacchette();
			creaGrip();
			creaScarpe();
			creaPolsino();
			creaNutrizione();
			creaAllenamento();
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

	private void creaGrip() {
		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		List<TipoScelta> tipiScelteTipologia=new ArrayList();

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.Il_guerriero);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,13);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Rovescio,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Rovescio,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Rovescio,30);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.L_artiglio);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,11);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,30);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,33);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.Il_machete);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,11);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,14);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,18);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,22);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,26);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,28);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,31);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,34);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,36);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.Il_cobra);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Rovescio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,12);
		listaAbilita.put(EnumAbilita.Rovescio,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.La_katana);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Rovescio,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Rovescio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Rovescio,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Rovescio,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Rovescio,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Rovescio,29);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.La_fucina);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,31);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,33);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.Grip_tattico);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Rovescio,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,10);
		listaAbilita.put(EnumAbilita.Rovescio,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Rovescio,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,12);
		listaAbilita.put(EnumAbilita.Rovescio,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,12);
		listaAbilita.put(EnumAbilita.Rovescio,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,13);
		listaAbilita.put(EnumAbilita.Rovescio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,14);
		listaAbilita.put(EnumAbilita.Rovescio,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,15);
		listaAbilita.put(EnumAbilita.Rovescio,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Grip,EnumGrip.Iltitano);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,22);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,27);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,29);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,32);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		tipiScelte.put(EnumTipoScelta.Grip, tipiScelteTipologia);
	}



	private void creaScarpe() {
		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		List<TipoScelta> tipiScelteTipologia=new ArrayList();

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.La_piuma);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,21);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,26);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,31);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,34);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,41);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,45);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,54);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.Il_rapace);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Agilita,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Agilita,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Agilita,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Agilita,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Agilita,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Agilita,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Agilita,32);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Agilita,36);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Agilita,40);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Agilita,43);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Agilita,47);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.Il_cacciatore);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Agilita,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Agilita,8);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Agilita,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,32);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,36);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Agilita,40);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Agilita,43);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Agilita,47);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.Il_piragna);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,12);
		listaAbilita.put(EnumAbilita.Agilita,13);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,13);
		listaAbilita.put(EnumAbilita.Agilita,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,14);
		listaAbilita.put(EnumAbilita.Agilita,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,14);
		listaAbilita.put(EnumAbilita.Agilita,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,15);
		listaAbilita.put(EnumAbilita.Agilita,31);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,18);
		listaAbilita.put(EnumAbilita.Agilita,42);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.La_shuriken);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Agilita,13);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Agilita,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Agilita,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Agilita,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,13);
		listaAbilita.put(EnumAbilita.Agilita,31);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,14);
		listaAbilita.put(EnumAbilita.Agilita,35);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,15);
		listaAbilita.put(EnumAbilita.Agilita,38);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,15);
		listaAbilita.put(EnumAbilita.Agilita,42);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.L_incudine);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Agilita,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Agilita,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Agilita,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Agilita,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Agilita,32);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Agilita,35);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Agilita,39);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Agilita,43);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Agilita,47);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.La_balistica);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Agilita,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Agilita,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Agilita,31);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Agilita,35);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Agilita,39);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Agilita,43);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Agilita,47);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Scarpa,EnumScarpe.TheHadesTreads);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,19);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,24);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,29);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,38);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,42);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,46);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,51);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,55);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		tipiScelte.put(EnumTipoScelta.Scarpa, tipiScelteTipologia);
	}

	private void creaPolsino() {
		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		List<TipoScelta> tipiScelteTipologia=new ArrayList();


		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.Il_Tomahawk);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,12);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,16);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,21);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,25);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,28);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,31);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,37);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.Il_razzo);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,2);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Volley,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Volley,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Volley,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Volley,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Volley,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Volley,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.Bandiera_pirata);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Volley,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Volley,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,13);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,13);
		listaAbilita.put(EnumAbilita.Volley,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,14);
		listaAbilita.put(EnumAbilita.Volley,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,15);
		listaAbilita.put(EnumAbilita.Volley,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,15);
		listaAbilita.put(EnumAbilita.Volley,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.Il_pappagallo_ara);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.Il_koi);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Volley,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Volley,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,9);
		listaAbilita.put(EnumAbilita.Volley,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,9);
		listaAbilita.put(EnumAbilita.Volley,13);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Volley,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Volley,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,11);
		listaAbilita.put(EnumAbilita.Volley,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,11);
		listaAbilita.put(EnumAbilita.Volley,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.L_orso_Kodiac);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Volley,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Volley,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Volley,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Volley,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Volley,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Volley,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.Il_gladiatore);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,13);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,18);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,22);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,26);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,29);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,32);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,35);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,38);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);
		ts = new TipoScelta(EnumTipoScelta.Polsino,EnumPolsino.Lo_scudo);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);
		
		tipiScelte.put(EnumTipoScelta.Polsino, tipiScelteTipologia);
	}

	private void creaNutrizione() {
		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		List<TipoScelta> tipiScelteTipologia=new ArrayList();


		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Proteina_magra);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,13);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,17);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,22);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,26);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,29);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,38);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Idratazione_aumentata);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Resistenza,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Resistenza,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Resistenza,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Macrobiotico);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,12);
		listaAbilita.put(EnumAbilita.Resistenza,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,12);
		listaAbilita.put(EnumAbilita.Resistenza,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,13);
		listaAbilita.put(EnumAbilita.Resistenza,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,14);
		listaAbilita.put(EnumAbilita.Resistenza,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,15);
		listaAbilita.put(EnumAbilita.Resistenza,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Dieta_vegana);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Resistenza,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Resistenza,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Resistenza,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Resistenza,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Resistenza,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Resistenza,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Resistenza,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Resistenza,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Dieta_keto);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,14);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,19);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,23);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,27);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,31);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,34);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,37);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,40);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Antiossidanti);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Resistenza,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,13);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Resistenza,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Resistenza,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Resistenza,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Resistenza,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Carico_di_carboidrati);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Resistenza,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Resistenza,14);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Resistenza,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Resistenza,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,12);
		listaAbilita.put(EnumAbilita.Resistenza,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Nutrizione,EnumNutrizione.Neutral_energy);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Volley,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Volley,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,13);
		listaAbilita.put(EnumAbilita.Volley,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,18);
		listaAbilita.put(EnumAbilita.Volley,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,20);
		listaAbilita.put(EnumAbilita.Volley,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,22);
		listaAbilita.put(EnumAbilita.Volley,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,25);
		listaAbilita.put(EnumAbilita.Volley,7);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,27);
		listaAbilita.put(EnumAbilita.Volley,7);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);
		tipiScelte.put(EnumTipoScelta.Nutrizione, tipiScelteTipologia);
	}

	private void creaAllenamento() {
		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		List<TipoScelta> tipiScelteTipologia=new ArrayList();


		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Resistenza);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,4);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,7);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,11);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,30);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Sprint);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,14);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,18);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,22);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,27);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,30);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,33);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,39);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Pilometria);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,2);
		listaAbilita.put(EnumAbilita.Servizio,1);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,3);
		listaAbilita.put(EnumAbilita.Servizio,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,3);
		listaAbilita.put(EnumAbilita.Servizio,4);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,7);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,11);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,5);
		listaAbilita.put(EnumAbilita.Servizio,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,5);
		listaAbilita.put(EnumAbilita.Servizio,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,5);
		listaAbilita.put(EnumAbilita.Servizio,30);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Powerlifting);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,12);
		listaAbilita.put(EnumAbilita.Servizio,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,13);
		listaAbilita.put(EnumAbilita.Servizio,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,14);
		listaAbilita.put(EnumAbilita.Servizio,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,14);
		listaAbilita.put(EnumAbilita.Servizio,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,15);
		listaAbilita.put(EnumAbilita.Servizio,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,18);
		listaAbilita.put(EnumAbilita.Servizio,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Sollevamento_pesi);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,7);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,11);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,29);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Fascia_di_resistenza);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,8);
		listaAbilita.put(EnumAbilita.Servizio,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Servizio,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Servizio,10);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Servizio,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,10);
		listaAbilita.put(EnumAbilita.Servizio,17);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,11);
		listaAbilita.put(EnumAbilita.Servizio,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,11);
		listaAbilita.put(EnumAbilita.Servizio,21);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,12);
		listaAbilita.put(EnumAbilita.Servizio,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Arrampicatore);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,7);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,11);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,4);
		listaAbilita.put(EnumAbilita.Servizio,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,5);
		listaAbilita.put(EnumAbilita.Servizio,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,5);
		listaAbilita.put(EnumAbilita.Servizio,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,5);
		listaAbilita.put(EnumAbilita.Servizio,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,6);
		listaAbilita.put(EnumAbilita.Servizio,29);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Allenamento,EnumAllenamento.Lunges);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,15);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,19);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,27);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,31);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,34);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,37);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Servizio,40);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);
		tipiScelte.put(EnumTipoScelta.Allenamento, tipiScelteTipologia);
	}


	private void creaRacchette() {
		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		List<TipoScelta> tipiScelteTipologia=new ArrayList();


		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.L_aquila);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,2);
		listaAbilita.put(EnumAbilita.Diritto,3);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Diritto,4);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Diritto,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Diritto,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Diritto,13);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Diritto,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Diritto,30);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.Il_patriota);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,6);
		listaAbilita.put(EnumAbilita.Diritto,11);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,6);
		listaAbilita.put(EnumAbilita.Diritto,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,6);
		listaAbilita.put(EnumAbilita.Diritto,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,6);
		listaAbilita.put(EnumAbilita.Diritto,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,7);
		listaAbilita.put(EnumAbilita.Diritto,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,7);
		listaAbilita.put(EnumAbilita.Diritto,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,8);
		listaAbilita.put(EnumAbilita.Diritto,30);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,8);
		listaAbilita.put(EnumAbilita.Diritto,33);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.L_entroterra);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,8);
		listaAbilita.put(EnumAbilita.Diritto,5);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Diritto,8);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Diritto,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Diritto,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,10);
		listaAbilita.put(EnumAbilita.Diritto,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,11);
		listaAbilita.put(EnumAbilita.Diritto,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,12);
		listaAbilita.put(EnumAbilita.Diritto,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.La_pantera);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,11);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,14);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,18);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,22);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,26);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,28);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,31);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,34);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,36);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.Il_samurai);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Diritto,6);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,9);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Diritto,25);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Diritto,27);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,6);
		listaAbilita.put(EnumAbilita.Diritto,29);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.Il_martello);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,6);
		listaAbilita.put(EnumAbilita.Diritto,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,7);
		listaAbilita.put(EnumAbilita.Diritto,15);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,7);
		listaAbilita.put(EnumAbilita.Diritto,19);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,7);
		listaAbilita.put(EnumAbilita.Diritto,23);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,7);
		listaAbilita.put(EnumAbilita.Diritto,26);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,8);
		listaAbilita.put(EnumAbilita.Diritto,28);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Diritto,31);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Rovescio,9);
		listaAbilita.put(EnumAbilita.Diritto,33);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.Bullseye);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,15);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,18);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,27);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,29);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,32);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		
		ts = new TipoScelta(EnumTipoScelta.Racchetta,EnumRacchette.Zeus);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,7);
		listaAbilita.put(EnumAbilita.Diritto,2);
		//
		//
		//
		//
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		//
		//
		//
		//
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Diritto,8);
		//
		//
		//
		//
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Diritto,12);
		//
		//
		//
		//
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Diritto,16);
		//
		//
		//
		//
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Diritto,18);
		//
		//
		//
		//
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Diritto,20);
		//
		//
		//
		//
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Diritto,22);
		//
		//
		//
		//
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,11);
		listaAbilita.put(EnumAbilita.Diritto,24);
		//
		//
		//
		//
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);
		
		tipiScelte.put(EnumTipoScelta.Racchetta, tipiScelteTipologia);
	}

	private void creaPersonaggi() {
		TipoScelta ts;
		Map<EnumAbilita, Integer> listaAbilita;
		List<TipoScelta> tipiScelteTipologia=new ArrayList();


		ts = new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Jonah);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,3);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,2);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,9);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,11);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,8);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,12);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,9);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,10);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,12);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,13);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,14);
		listaAbilita.put(EnumAbilita.Rovescio,11);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,18);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Diritto,15);
		listaAbilita.put(EnumAbilita.Rovescio,12);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Hope);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,7);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,9);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,12);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,17);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,8);
		listaAbilita.put(EnumAbilita.Volley,10);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,19);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,9);
		listaAbilita.put(EnumAbilita.Volley,10);
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Resistenza,10);
		listaAbilita.put(EnumAbilita.Servizio,10);
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,22);
		listaAbilita.put(EnumAbilita.Resistenza,11);
		listaAbilita.put(EnumAbilita.Servizio,10);
		listaAbilita.put(EnumAbilita.Volley,12);
		listaAbilita.put(EnumAbilita.Diritto,12);
		listaAbilita.put(EnumAbilita.Rovescio,11);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Florence);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,6);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,1);
		listaAbilita.put(EnumAbilita.Volley,2);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,2);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,2);
		listaAbilita.put(EnumAbilita.Volley,2);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,12);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,2);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,10);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,16);
		listaAbilita.put(EnumAbilita.Resistenza,11);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,18);
		listaAbilita.put(EnumAbilita.Resistenza,12);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,20);
		listaAbilita.put(EnumAbilita.Resistenza,14);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,22);
		listaAbilita.put(EnumAbilita.Resistenza,15);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,24);
		listaAbilita.put(EnumAbilita.Resistenza,16);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,27);
		listaAbilita.put(EnumAbilita.Resistenza,18);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,29);
		listaAbilita.put(EnumAbilita.Resistenza,19);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Leo);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,1);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,2);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,7);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,9);
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,12);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,10);
		listaAbilita.put(EnumAbilita.Volley,10);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Volley,11);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,12);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,17);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,13);
		listaAbilita.put(EnumAbilita.Volley,13);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,19);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,14);
		listaAbilita.put(EnumAbilita.Volley,14);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,20);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,15);
		listaAbilita.put(EnumAbilita.Volley,16);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,22);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,16);
		listaAbilita.put(EnumAbilita.Volley,17);
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Kaito);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,6);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,1);
		listaAbilita.put(EnumAbilita.Volley,2);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,2);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,2);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,12);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,2);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,10);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,16);
		listaAbilita.put(EnumAbilita.Resistenza,11);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,18);
		listaAbilita.put(EnumAbilita.Resistenza,12);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,20);
		listaAbilita.put(EnumAbilita.Resistenza,14);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,22);
		listaAbilita.put(EnumAbilita.Resistenza,15);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,24);
		listaAbilita.put(EnumAbilita.Resistenza,16);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,27);
		listaAbilita.put(EnumAbilita.Resistenza,18);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,29);
		listaAbilita.put(EnumAbilita.Resistenza,19);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Victoria);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,2);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,2);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,6);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,9);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,11);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,8);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,11);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,9);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,12);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,10);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,13);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,14);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,17);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,15);
		listaAbilita.put(EnumAbilita.Rovescio,11);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,18);
		listaAbilita.put(EnumAbilita.Resistenza,9);
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Diritto,16);
		listaAbilita.put(EnumAbilita.Rovescio,12);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Diana);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,1);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,6);
		listaAbilita.put(EnumAbilita.Resistenza,1);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,3);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,7);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,8);
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,13);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,9);
		listaAbilita.put(EnumAbilita.Volley,10);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,10);
		listaAbilita.put(EnumAbilita.Volley,12);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,16);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Volley,13);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,18);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,14);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,20);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,13);
		listaAbilita.put(EnumAbilita.Volley,15);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,22);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,14);
		listaAbilita.put(EnumAbilita.Volley,16);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,23);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,15);
		listaAbilita.put(EnumAbilita.Volley,18);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,10);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Mei_Li);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,3);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,5);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,3);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,4);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,7);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,10);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,5);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,6);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,12);
		listaAbilita.put(EnumAbilita.Resistenza,6);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,9);
		listaAbilita.put(EnumAbilita.Diritto,9);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,8);
		listaAbilita.put(EnumAbilita.Volley,10);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);

		ts=new TipoScelta(EnumTipoScelta.Personaggio,EnumPersonaggi.Luc);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Resistenza,2);
		listaAbilita.put(EnumAbilita.Servizio,4);
		listaAbilita.put(EnumAbilita.Volley,2);
		listaAbilita.put(EnumAbilita.Diritto,5);
		listaAbilita.put(EnumAbilita.Rovescio,4);
		ts.getCaratteristiche().put(1, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		ts.getCaratteristiche().put(2, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,4);
		listaAbilita.put(EnumAbilita.Resistenza,3);
		listaAbilita.put(EnumAbilita.Servizio,6);
		listaAbilita.put(EnumAbilita.Volley,3);
		listaAbilita.put(EnumAbilita.Diritto,7);
		listaAbilita.put(EnumAbilita.Rovescio,5);
		ts.getCaratteristiche().put(3, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,8);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,7);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,8);
		listaAbilita.put(EnumAbilita.Rovescio,6);
		ts.getCaratteristiche().put(4, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,9);
		listaAbilita.put(EnumAbilita.Resistenza,4);
		listaAbilita.put(EnumAbilita.Servizio,8);
		listaAbilita.put(EnumAbilita.Volley,4);
		listaAbilita.put(EnumAbilita.Diritto,10);
		listaAbilita.put(EnumAbilita.Rovescio,7);
		ts.getCaratteristiche().put(5, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,11);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,9);
		listaAbilita.put(EnumAbilita.Volley,5);
		listaAbilita.put(EnumAbilita.Diritto,11);
		listaAbilita.put(EnumAbilita.Rovescio,8);
		ts.getCaratteristiche().put(6, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,14);
		listaAbilita.put(EnumAbilita.Resistenza,5);
		listaAbilita.put(EnumAbilita.Servizio,10);
		listaAbilita.put(EnumAbilita.Volley,6);
		listaAbilita.put(EnumAbilita.Diritto,12);
		listaAbilita.put(EnumAbilita.Rovescio,9);
		ts.getCaratteristiche().put(7, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,0);
		listaAbilita.put(EnumAbilita.Resistenza,0);
		listaAbilita.put(EnumAbilita.Servizio,0);
		listaAbilita.put(EnumAbilita.Volley,0);
		listaAbilita.put(EnumAbilita.Diritto,0);
		listaAbilita.put(EnumAbilita.Rovescio,0);
		ts.getCaratteristiche().put(8, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,15);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,11);
		listaAbilita.put(EnumAbilita.Volley,7);
		listaAbilita.put(EnumAbilita.Diritto,14);
		listaAbilita.put(EnumAbilita.Rovescio,11);
		ts.getCaratteristiche().put(9, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,19);
		listaAbilita.put(EnumAbilita.Resistenza,7);
		listaAbilita.put(EnumAbilita.Servizio,12);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,15);
		listaAbilita.put(EnumAbilita.Rovescio,12);
		ts.getCaratteristiche().put(10, listaAbilita);
		listaAbilita=new TreeMap();
		listaAbilita.put(EnumAbilita.Agilita,18);
		listaAbilita.put(EnumAbilita.Resistenza,8);
		listaAbilita.put(EnumAbilita.Servizio,13);
		listaAbilita.put(EnumAbilita.Volley,8);
		listaAbilita.put(EnumAbilita.Diritto,16);
		listaAbilita.put(EnumAbilita.Rovescio,13);
		ts.getCaratteristiche().put(11, listaAbilita);
		tipiScelteTipologia.add(ts);
		
		tipiScelte.put(EnumTipoScelta.Personaggio, tipiScelteTipologia);
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
	Map<EnumOggetti,Integer> livelliCarte=new HashMap();
	Integer iMaxLivello;
	
	
}


