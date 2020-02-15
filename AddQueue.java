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
public class AddQueue implements Runnable {

    private Thread t;
    private List<Group> groupQueue;
    private List<Group> groupPeople;

    AddQueue(List<Group> groupQueue, List<Group> groupPeople) {
        this.groupQueue = groupQueue;
        this.groupPeople = groupPeople;
    }

    public void run() {
        System.out.println("Running пополнение очереди");
        try {

            while (!groupPeople.isEmpty()) {
                groupQueue.add(groupPeople.get(0));
                if (!groupQueue.isEmpty()) {
                    System.out.println("Очередь на данный момент");
                    show(groupQueue);
                } else {
                    System.out.println("Нет групп в очереди");
                }
                groupPeople.remove(0);
                Thread.sleep(1000 * (2 + (int) (Math.random() * 3)));
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
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
