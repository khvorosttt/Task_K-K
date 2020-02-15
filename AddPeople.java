/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class AddPeople {
    AddPeople(List <Group> groupPeople) throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "Group.txt")));
        String A;
        while((A = in.readLine())!=null){
            String[] data = A.split(" ");
            Group g = new Group(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            groupPeople.add(g);
        }
        
    }
}
