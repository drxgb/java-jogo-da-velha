/**
 * Interface IA
 * <p>Contrato responsável em realizar ações
 * da IA (Inteligência Artificial) do jogo</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.jogo.ia;

import com.drxgb.consolegame.jogo.Jogo;

public interface AcaoIA {

	void agir(Jogo jogo);
	
}
