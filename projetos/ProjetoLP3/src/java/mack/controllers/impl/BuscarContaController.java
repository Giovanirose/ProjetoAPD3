package mack.controllers.impl;

import bancodao.BancoDaoException;
import bancodao.ConexaoException;
import bancodao.ConexaoInterface;
import bancodao.ConexaoJavaDb;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import bancodao.Conta;
import bancodao.ContaDaoInterface;
import bancodao.ContaDaoRelacional;

public class BuscarContaController extends AbstractController {

    public void execute() {
        try {
            ConexaoInterface conexao = new ConexaoJavaDb(
                    "localhost", 1527, "app", "app", "sistema_bancario");
            boolean conexaoEstabelecida = false;
            ContaDaoInterface dao = null;
            Conta conta = null;
            Long id = Long.parseLong(this.getRequest().getParameter("numero"));
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
                    conta = dao.buscarContaNumero(id);
                }catch(BancoDaoException ex){
                    ex.printStackTrace();
                }
            }
            this.setReturnPage("/buscarConta.jsp");
            this.getRequest().setAttribute("buscar_conta", conta);
            this.getRequest().setAttribute("nro_conta", id);
        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
