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
public class TimeDeleteQueue implements Runnable {

    private Thread t;
    private List<Group> groupQueue;
    private List<Group> groupPeople;

    TimeDeleteQueue(List<Group> groupQueue, List<Group> groupPeople) {
        this.groupQueue = groupQueue;
        this.groupPeople = groupPeople;
        //System.out.println("Creating ");
    }

    public void run() {
        System.out.println("Running группы из очереди могут уходить");
        try {
            while (!groupQueue.isEmpty() || !groupPeople.isEmpty()) {
                    for (int i = 0; i < groupQueue.size(); i++) {
                        groupQueue.get(i).setpQueue(1);
                        if (groupQueue.get(i).getQueue() == groupQueue.get(i).getpQueue()) {
                            System.out.println("Группа из "+ groupQueue.get(i).getAmount()+" человек ушла, её очередь не наступила вовремя");
                            groupQueue.remove(i);
                            i--;
                        }
                    }
                    Thread.sleep(1000*(3+(int)(Math.random()*3)));
            }
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
    }

    public void show(List<Group> list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).getAmount() + " ");
            }
            System.out.println();
        }
    }

    public void start() {
        //System.out.println("Starting ");
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
