package mack.controllers.impl;

import bancodao.BancoDaoException;
import bancodao.ConexaoException;
import bancodao.ConexaoInterface;
import bancodao.ConexaoJavaDb;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import bancodao.ContaDaoInterface;
import bancodao.ContaDaoRelacional;

public class RemoverContaController extends AbstractController {

    public void execute() {
        try {
            ConexaoInterface conexao = new ConexaoJavaDb(
                    "localhost", 1527, "app", "app", "sistema_bancario");
            boolean conexaoEstabelecida = false;
            ContaDaoInterface dao = null;
            Long nro_conta = Long.parseLong(this.getRequest().getParameter("numero"));
            System.out.println(nro_conta);
            int result = 0;
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
                    result = dao.apagar(nro_conta);
                }catch(BancoDaoException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println(result);
            this.setReturnPage("/removerConta.jsp");
            this.getRequest().setAttribute("remover_conta", result);
        } catch (Exception ex) {
            Logger.getLogger(ListaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
