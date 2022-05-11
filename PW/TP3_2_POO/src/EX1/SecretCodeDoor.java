/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import java.util.Scanner;

/**
 *
 * @author Valdrin Salihi
 */
public class SecretCodeDoor extends AutoLockDoor{
    private final int DEFAULT_CODE = 0000;
    
    protected boolean locked;
    private final int code;
    
    public SecretCodeDoor(){
        super();
        this.code = DEFAULT_CODE;
    }
    
    public SecretCodeDoor(int x){
        this.code = x;
    }
    
    public int getCode(){
        return code;
    }
    
    public void unlock(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le code");
        int codeEnter = sc.nextInt();
        
        if(codeEnter == code){
            this.locked = false;
        }
        else{
            System.out.println("Code invalide");
        }
    }
    
    @Override
    public void close(){
        this.isOpen = false;
        super.lock();
    }
}
