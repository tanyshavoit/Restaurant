/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

/**
 *
 * @author Vita
 */
class Request {

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
    
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public String getParam(int i){
        if (i>=params.length)
            throw new java.lang.ArrayIndexOutOfBoundsException();
        return params[i];
    }
    
    private String[] params;
    private String method;

}
