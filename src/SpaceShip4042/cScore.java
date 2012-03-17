/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SpaceShip4042;

import javax.microedition.rms.RecordStore;

/**
 *
 * @author Bruno Cicanci
 * @date 09/14/2009
 */
public class cScore
{
    private String KEY = "SpaceShip4042";
    private int iScore;

    public cScore()
    {

    }

    public cScore(int score)
    {
        iScore = score;
    }

    protected void writeData(int number)
    {
        RecordStore rs = null;
        try
        {
            // Converts the string to an array of byte data
            String score = "" + iScore;
            byte[] data = score.getBytes();
            // Opens a RecordStore
            rs = RecordStore.openRecordStore((KEY + number), true);
            // If there were no older data, creates a new record
            if (rs.getNumRecords() == 0)
            {
                rs.addRecord(data, 0, data.length);
            }
            else
            {
                //Overwrites the record
                rs.setRecord(1, data, 0, data.length);
            }
        }
        catch (Exception ex)
        {
                System.out.print(ex);
        }
        finally
        {
            try
            {
                // Closes the RecordStore
                if (rs != null) rs.closeRecordStore();
            }
            catch (Exception ex)
            {
                System.out.print(ex);
            }
        }
    }

    protected String readData(int number)
    {
        RecordStore rs = null;
        try
        {
            // Opens a RecordStore
            rs = RecordStore.openRecordStore((KEY + number), false);
            // Gets the data from the record
            byte [] data = rs.getRecord(1);
            // Gets a string from the array of byte data
            return new String(data);
        }
        catch (Exception ex)
        {
            System.out.print(ex);
        }
        finally
        {
            try
            {
                // Closes the RecordStore
                if (rs != null)
                    rs.closeRecordStore();
            }
            catch (Exception ex)
            {
                System.out.print(ex);
            }
        }
        return "";
    }
}
