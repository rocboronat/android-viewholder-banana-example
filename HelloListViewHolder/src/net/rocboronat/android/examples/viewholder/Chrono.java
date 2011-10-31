package net.rocboronat.android.examples.viewholder;

import java.util.HashMap;

/**
 * Classe per a fer càlculs de temps, processar how many temps ha passat des
 * de A a B, fer càlculs sobre el futur de l'univers i d'altres petits detalls
 * que conduiran a Emmanuel Goldstein a liderar la revolució.
 *
 * @author Roc Boronat
 * @date 01/03/2010
 */

public class Chrono {

	HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
	Integer i = new Integer(-1);

	public Chrono() {

	}

	/**
	 * S'inicia un crono amb un ID generat. En el moment
	 * de fer stop() amb aquest ID, es retornaran els
	 * millis que han passat des de l'inici.
	 *
	 * @param id Integer que identifica aquest crono entre els demés.
	 * @return id que s'ha generat, per poder fer stop() posteriorment.
	 */

	public Integer start() {
		hm.put(i, System.currentTimeMillis());
		return i--;
	}

	/**
	 * S'inicia un crono amb aquest ID. En el moment
	 * de fer stop() amb aquest ID, es retornaran els
	 * millis que han passat.
	 *
	 * @param id Integer que identifica aquest crono entre els demés.
	 */

	public void start(Integer id) {
		hm.put(id, System.currentTimeMillis());
	}

	/**
	 * Mètode per a saber quant de temps ha passat des de que hem començat a
	 * comptar i, a més, netejar la informació. Es dedueix que mai més
	 * s'utilitzarà tal valor, s'allibera memòria, etc etc etc
	 *
	 * @param id Integer que identifica el crono que volem aturar.
	 * @return el temps transcorregut entre start(x) i stop(x) en millis.
	 */

	public long stop(Integer id) {
		Long l = hm.get(id);
		hm.remove(id);
		return System.currentTimeMillis() - l;
	}

	/**
	 * Mètode per a saber quant de temps ha passat des de que hem començat a
	 * comptar.
	 *
	 * @param id Integer que identifica el crono sobre el que informar-se.
	 * @return el temps transcorregut entre start(x) i stop(x) en millis.
	 */

	public long checkpoint(Integer id) {
		Long l = hm.get(id);
		return System.currentTimeMillis() - l;
	}
}