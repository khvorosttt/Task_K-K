/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class TimeDeleteTable implements Runnable {

    private Thread t;
    //private String threadName;
    private List<Group> groupTableBusy;
    private List<Integer> groupTableFree;
    private List<Group> groupQueue;

    TimeDeleteTable(List<Group> groupTableBusy, List<Integer> groupTableFree, List<Group> groupQueue) {
        this.groupTableBusy = groupTableBusy;
        this.groupTableFree = groupTableFree;
        this.groupQueue=groupQueue;
        //System.out.println("Creating ");
    }

    public void run() {
        System.out.println("Running группы могут покидать столы");
        try {
            while (!groupTableBusy.isEmpty()||!groupQueue.isEmpty()) {
                for(int i=0;i<groupTableBusy.size();i++){
                    groupTableBusy.get(i).setpTable(1);
                    if(groupTableBusy.get(i).getTable()==groupTableBusy.get(i).getpTable()){
                        groupTableFree.add(groupTableBusy.get(i).getNumber());
                        System.out.println("Появился свободный стол на "+groupTableBusy.get(i).getNumber()+" мест");
                        groupTableBusy.remove(i);
                        i--;
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
