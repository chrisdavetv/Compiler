/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compilersource.symboltable;

import compile.compilersource.symboltable.Value.PrimitiveType;

/**
 *
 * @author chris
 */
public class Array {
    private final static String TAG = "Array";
	
    private Value[] ValueArray;
    PrimitiveType arrayPrimitiveType;
    private String arrayIdentifier;
    private boolean finalFlag = false;

    public Array(PrimitiveType primitiveType, String identifier) {
            this.arrayPrimitiveType = primitiveType;
            this.arrayIdentifier = identifier;
    }

    public void setPrimitiveType(PrimitiveType primitiveType) {
            this.arrayPrimitiveType = primitiveType;
    }

    public PrimitiveType getPrimitiveType() {
            return this.arrayPrimitiveType;
    }

    public void markFinal() {
            this.finalFlag = true;
    }

    public boolean isFinal() {
            return this.finalFlag;
    }

    public void initializeSize(int size) {
            this.ValueArray = new Value[size];
            //Log.i(TAG, "// array initialized to size " +this.ValueArray.length);
    }

    public int getSize() {
            return this.ValueArray.length;
    }

    public void updateValueAt(Value Value, int index) {
            if(index >= this.ValueArray.length) {
                    //Console.log(LogType.ERROR, String.format(ErrorRepository.getErrorMessage(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS), this.arrayIdentifier));
                    return;
            }
            this.ValueArray[index] = Value;
    }

    public Value getValueAt(int index) {
            if(index >= this.ValueArray.length) {
                    //Console.log(//LogType.ERROR, String.format(ErrorRepository.getErrorMessage(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS), this.arrayIdentifier));
                    return this.ValueArray[this.ValueArray.length - 1];
            }
            else {
                    return this.ValueArray[index];
            }
    }

    /*
     * Utility function that returns an arary of specified primitive type.
     */
    public static Array createArray(String primitiveTypeString, String arrayIdentifier) {
            //identify primitive type
            PrimitiveType primitiveType = PrimitiveType.NOT_YET_IDENTIFIED;

            if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString)) {
                    primitiveType = PrimitiveType.BOOLEAN;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_BYTE, primitiveTypeString)) {
                    primitiveType = PrimitiveType.BYTE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_CHAR, primitiveTypeString)) {
                    primitiveType = PrimitiveType.CHAR;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_DOUBLE, primitiveTypeString)) {
                    primitiveType = PrimitiveType.DOUBLE;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString)) {
                    primitiveType = PrimitiveType.FLOAT;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_INT, primitiveTypeString)) {
                    primitiveType = PrimitiveType.INT;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_LONG, primitiveTypeString)) {
                    primitiveType = PrimitiveType.LONG;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_SHORT, primitiveTypeString)) {
                    primitiveType = PrimitiveType.SHORT;
            }
            else if(Keywords.matchesKeyword(Keywords.PRIMITIVE_TYPE_STRING, primitiveTypeString)) {
                    primitiveType = PrimitiveType.STRING;
            }

            Array Array = new Array(primitiveType, arrayIdentifier);

            return Array;
    }
}
