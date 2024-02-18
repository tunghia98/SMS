/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author M S I
 */
public class Function {
    private String functionID;
    private String functionName;
    private int status;

    public Function(String functionID, String functionName, int status) {
        this.functionID = functionID;
        this.functionName = functionName;
        this.status = status;
    }

    public Function() {
    }

    public String getFunctionID() {
        return functionID;
    }

    public void setFunctionID(String functionID) {
        this.functionID = functionID;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Function{" + "functionID=" + functionID + ", functionName=" + functionName + ", status=" + status + '}';
    }

    
}
