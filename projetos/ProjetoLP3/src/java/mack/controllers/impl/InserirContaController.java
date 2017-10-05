package mack.controllers.impl;

import bancodao.BancoDaoException;
import bancodao.ConexaoException;
import bancodao.ConexaoInterface;
import bancodao.ConexaoJavaDb;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import bancodao.Conta;
import bancodao.ContaDaoInterface;
import bancodao.ContaDaoRelacional;
import java.math.BigDecimal;

public class InserirContaController extends AbstractController {

    public void execute() {
        try {
            ConexaoInterface conexao = new ConexaoJavaDb(
                    "localhost", 1527, "app", "app", "sistema_bancario");
            boolean conexaoEstabelecida = false;
            ContaDaoInterface dao = null;
            Long nro_conta = Long.parseLong(this.getRequest().getParameter("numero"));
            BigDecimal saldo = new BigDecimal(this.getRequest().getParameter("saldo"));
            Conta conta = new Conta(nro_conta,saldo);
            int result = -1;
            try {
                dao = new ContaDaoRelacional(conexao);
                conexaoEstabelecida = true;
            } catch (ConexaoException e) {
                conexaoEstabelecida = false;
            } catch (BancoDaoException ex) {
                conexaoEstabelecida = false;
            }
            if(conexaoEstabelecida){                
                try{
                    result = dao.inserir(conta);
                }catch(BancoDaoException ex){
                    ex.printStackTrace();
                }
            }
            this.setReturnPage("/inserirConta.jsp");
            this.getRequest().setAttribute("inserir_conta", result);
        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
