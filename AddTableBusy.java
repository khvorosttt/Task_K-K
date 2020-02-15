package solution;

import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class AddTableBusy implements Runnable {

    private Thread t;
    private List<Group> groupQueue;
    private List<Integer> groupTableFree;
    private List<Group> groupTableBusy;
    private List<Group> groupPeople;

    AddTableBusy(List<Group> groupQueue, List<Integer> groupTableFree, List<Group> groupTableBusy, List<Group> groupPeople) {
        this.groupQueue = groupQueue;
        this.groupTableFree = groupTableFree;
        this.groupTableBusy = groupTableBusy;
        this.groupPeople = groupPeople;
    }

    public void run() {
        System.out.println("Running столы можно занимать");
        try {
            while (!groupQueue.isEmpty() || !groupPeople.isEmpty()) {
                for (int i = 0; i < groupTableFree.size(); i++) {
                        for (int j = 0; j < groupQueue.size(); j++) {
                            if (groupTableFree.get(i) == groupQueue.get(j).getAmount()) {
                                groupTableBusy.add(groupQueue.get(j));
                                System.out.println("Стол на "+groupTableFree.get(i)+" места Занят(заняла группа из "+groupQueue.get(j).getAmount()+" человек)");
                                groupQueue.get(j).setNumber(groupTableFree.get(i));
                                groupQueue.remove(j);
                                j--;
                                groupTableFree.remove(i);
                                i--;
                                break;
                            }
                        }
                    }
                    for (int i = 0; i < groupTableFree.size(); i++) {
                        for (int j = 0; j < groupQueue.size(); j++) {
                            if (groupTableFree.get(i) > groupQueue.get(j).getAmount()) {
                                groupTableBusy.add(groupQueue.get(j));
                                System.out.println("Стол на "+groupTableFree.get(i)+" места Занят(заняла группа из "+groupQueue.get(j).getAmount()+" человек)");
                                groupQueue.get(j).setNumber(groupTableFree.get(i));
                                groupQueue.remove(j);
                                j--;
                                groupTableFree.remove(i);
                                i--;
                                break;
                            }
                        }
                    }
                    Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
    }

    public void show(List<Integer> list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
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
