/**
 * Interface Eventos
 * <p>Contrato que implementa a��es de uma
 * aplica��o.</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package com.drxgb.consolegame.app;

public interface Eventos {

	/**
	 * Realiza a��es de pr�-configura��o da aplica��o.
	 */
	void iniciar();
	
	/**
	 * Atualiza o estado do jogo constantemente.
	 * Normalmente aplica-se um loop neste m�todo
	 * e este la�o ser� rompido quando atender
	 * algum requisito de encerramento de jogo.
	 */
	void atualizar();
	
	/**
	 * Realiza a��es ap�s o encerramento da aplica��o.
	 */
	void encerrar();
	
}
