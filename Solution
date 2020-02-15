/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Shaper s = new Shaper();
        List<Group> groupPeople = new ArrayList<>();
        AddPeople people = new AddPeople(groupPeople);
        List<Group> groupQueue = new ArrayList<>();
        List<Integer> groupTableFree = new ArrayList<>();
        List<Group> groupTableBusy = new ArrayList<>();
        for (int i = 2; i < 6; i++) {
            groupTableFree.add(i);
        }
        AddQueue a = new AddQueue(groupQueue, groupPeople);
        a.start();
        AddTableBusy b = new AddTableBusy(groupQueue, groupTableFree, groupTableBusy, groupPeople);
        b.start();
        TimeDeleteQueue q = new TimeDeleteQueue(groupQueue,groupPeople);
        q.start();
        TimeDeleteTable t = new TimeDeleteTable(groupTableBusy, groupTableFree, groupQueue);
        t.start();

    }

}
