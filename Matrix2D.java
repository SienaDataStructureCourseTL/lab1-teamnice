import java.util.Random;

/**
 *  A class representing a square matrix with some methods to manipulate
 *  such matrices.
 *  
 * @author Jim Teresco, modified by Prof. White and (your names here)
 * @version Fall 2019
 */
public class Matrix2D 
{   
    // the actual matrix data storage, space to be allocated by the constructor
    private int [][] data;

    /**
     * A basic constructor to allocate but not otherwise initialize a matrix, so
     * by the rules of Java, all entries are initially 0.
     * 
     * @param size The desired size of the square matrix.
     */
    public Matrix2D(int size) 
    {
        data = new int[size][size];
    }

    /**
     * Initialize the entries randomly within a range.
     * 
     * @param low The low end of the range.
     * @param high The high end of the range.
     */ 
    public void randomInit(int low, int high) 
    {    
        Random r = new Random();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                data[row][col] = r.nextInt(high-low) + low;
            }
        }      
    }

    /**
     * Make this the identity matrix.
     */ 
    public void setToIdentity() {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                if (row == col) {
                    data[row][col] = 1;
                }
                else {
                    data[row][col] = 0;
                }
            }
        }      
    }

    /**
     * Element mutator.  Throws an exception if the row or column is not valid.
     * 
     * @param row The row index of the element to be changed.
     * @param col The column index of the element to be changed.
     * @param value The new value to be assigned at the input row and column location.
     */ 
    public void set(int row, int col, int value) throws Matrix2DIndexOutOfBoundsException 
    {    
        if (row < 0 || row >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Row", row, data.length);
        }

        if (col < 0 || col >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Column", col, data.length);
        }

        data[row][col] = value;
    }

    /**
     * Element accessor.  Throws an exception if row or column is not valid.
     * 
     * @param The row of the element to be returned.
     * @param The column of the element to be returned.
     * @return The element located at the input row and column.
     */
    public int get(int row, int col) throws Matrix2DIndexOutOfBoundsException 
    {    
        if (row < 0 || row >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Row", row, data.length);
        }

        if (col < 0 || col >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Column", col, data.length);
        }

        return data[row][col];
    }

    /**
     * Returns the largest value in the matrix.
     * 
     * @param Returns the largest value in the matrix.
     */
    public int maxValue()
    {
        int mvalue = 0;
        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data.length; col++)
            {
                if (data[row][col] > mvalue)
                {
                    mvalue = data[row][col];
                }
            }
        }
        return mvalue;
    }

    /**
     *  Compare two matrices for equality.  Two matricies are equal if they have the
     *  same dimensions and the same elements at every location in the matrix.
     *  
     *  Note that we must take a parameter of type Object to override the inherited 
     *  equals method. 
     *  
     *  @param other The Matrix2D object to be compared to this matrix.
     */ 
    public boolean equals(Object other)
    {
        Matrix2D otr = (Matrix2D) other;

        if (data.length != otr.data.length){
            return false;
        }

        for(int col = 0; col < data.length; col++)
        {
            for(int row = 0; row < data.length; row++)
            {
                //if(data[row][col] == otr.get(row,col))
                //{
                //    return true;
                //}
            }
        }

        return false;
    }

    /**
     *  Nondestructive matrix-matrix add.  Throws an exception if the input 
     *  matrix does not have the same dimensions as this matrix.
     *  
     *  Create a new array whose elements are the sum of the elements of
     *  the input matrix and this matrix for the same row and column 
     *  indexes.
     *  
     *  @param other The Matrix2D object to be compared to this matrix.
     *  @return A new matrix whose elements are the sum of the input
     *          matrix and this matrix for the same row and column
     *          indexes.
     */ 
    public Matrix2D add(Matrix2D other) throws Matrix2DSizeMismatchException, Matrix2DIndexOutOfBoundsException
    {    
        if (data.length != other.data.length) {
            throw new Matrix2DSizeMismatchException(data.length, other.data.length);
        }
        Matrix2D secondArr = new Matrix2D(data.length);
        
        for(int col = 0; col < data.length; col++)
        {
            for(int row = 0; row < data.length; row++)
            {
                secondArr.set(row, col, other.get(row,col) + data[col][row]);
            }
        }
        
        return secondArr;
    }

    /**
     * Multiples every entry in this matrix by the input value.
     * 
     * @param by The amount by which the matrix is scaled.
     */
    public void scale(int by) throws Matrix2DIndexOutOfBoundsException 
    {
        
        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data.length; col++)
            {
                set(row,col,data[row][col] * by);
            }
        }
    }

    /**
     * Return the matrix as a String that will print in a nice format.
     * 
     * @return The matrix as a String that will print in a nice format.
     */
    public String toString() 
    {    
        // use a StringBuffer to build up an answer more efficiently
        StringBuffer sb = new StringBuffer();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                sb.append(data[row][col]);
                if (col != data.length-1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args){

        Matrix2D test = new Matrix2D(10);
        Matrix2D test2 = new Matrix2D(10);
        test.randomInit(0,15);
        test2.randomInit(0,15);
        System.out.println(test.toString());
        System.out.println();
        System.out.print(test.maxValue());
        System.out.println();
        System.out.println(test.toString());
        System.out.println(test2.toString());
        System.out.println();
        System.out.println(test.equals(test2));
        
    }
}