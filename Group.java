/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;
/**
 *
 * @author Lenovo
 */
public class Group {
    private int amount;//количество человек в группе
    private int number;//информация о столике
    private int tTable;//время, которое может провести за столом
    private int tQueue;//время, которое может провести в очереди
    private int pTable;//время, которое уже провёл за столом
    private int pQueue;//время, которое уже провёл в очереди
    
    Group(int amount,int tTable, int tQueue){
        this.amount=amount;
        number=0;
        this.tTable=tTable;
        this.tQueue=tQueue;
        pTable=0;
        pQueue=0;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public int getAmount(){
        return amount;
    }
    public int getTable(){
        return tTable;
    }
    public int getQueue(){
        return tQueue;
    }
    public int getpTable(){
        return pTable;
    }
    public int getpQueue(){
        return pQueue;
    }
    public void setpTable(int i){
        pTable=pTable+i;
    }
    public void setpQueue(int i){
        pQueue=pQueue+i;
    }       
}
