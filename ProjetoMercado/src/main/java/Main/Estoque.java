/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.ArrayList;

/**
 *
 * @author pcezar
 */
public class Estoque extends Localizacao {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Integer> quantidadesDoProduto=new ArrayList<>();// qtd respectiva  de cada produto no estoque da mesma possição do arrayList de produtos

    public Estoque(String localizacao) {
        super(localizacao);
    }
    public void adicionaNoEstoque(Produto x,int quantidade){
        produtos.add(x);
        quantidadesDoProduto.add(quantidade);
    }
    public boolean checaDisponibilidade(String x){
        for(int i=0;i<produtos.size();i++){
            if(produtos.get(i).getNome().equals(x)){
                return true;
            }
        }
        
        return false;
                
    }
    public int checaQuantidade(String x){
        if (checaDisponibilidade(x)== true){
        for(int i=0;i<produtos.size();i++){
            if(produtos.get(i).getNome().equals(x)){
                return quantidadesDoProduto.get(i);
                }
            }
        }
    return -1;
    }
    public void retiraEstoque(int quantidade,String x){
        int qtd=checaQuantidade(x);
        if(qtd<=0){System.out.println("quantidade acima da disponivel");}
        for(int i=0;i<produtos.size();i++){
            if(produtos.get(i).getNome().equals(x)){
                int numero=qtd-quantidade;
                quantidadesDoProduto.set(i,numero);
            }
        }
                
    }
}
