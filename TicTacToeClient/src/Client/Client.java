/*
* The MIT License
*
* Copyright 2015 LukeMcNemee.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package Client;


import java.io.*;
/**
 *
 * @author LukeMcNemee
 */
public interface Client {
    
    /**
     * připojí se k serveru
     * @param IP adresa (127.0.0.1 pokud server běží na stejném počítači)
     * @param port (předem domluvená hodnota, ideálně v rozsahu 1000+ )
     * @return 0
     * @throws IOException pokud není možné navázat spojení (server neběží nebo již nemá volné místo atd.)
     */
    public int connect(String IP, int port) throws IOException;
    
    /**
     * ukončí existující spojení
     * @return 0
     * @throws IOException 
     */
    public int disconnect() throws IOException;
    
    /**
     * dotaz na server, jaký je stav, buď hra skončila, poté vrací výsledek, nebo neskončila a vrací WAIT, nebo PLAY, podle situace kdo hraje
     * @return současný stav
     * @throws IOException 
     */
    public State getStatus() throws IOException;
    
    /**
     * vrátí velikost mřížky (celková velikost pole n, tedy souřadnice v poli jsou v rozsahu 0 - (n-1) )
     * @return velikost hrací mřížky
     * @throws IOException 
     */
    public int getSize() throws IOException;
    
    /**
     * dotaz na přiřazený symbol
     * @return 'X' nebo 'O'
     * @throws IOException 
     */
    public char getColor() throws IOException;
    
    /**
     * dotaz na symbol na pozici v poli
     * @param x 
     * @param y
     * @return 'X', 'Y', nebo '_' pro prázdné místo, může vrátit jinou hodnotu v případě chyby
     * @throws IOException 
     */
    public char getGrid(int x, int y) throws IOException;
    
    /**
     * požadavek na zahrání na konkrétní souřadnice
     * @param x
     * @param y
     * @return 0 v případě úspěchu, méně jak 0 v případě chyby
     *  -1 = špatné pořadí (má hrát druhý hráč)
     *  -2 = špatné souřadnice, mimo rozsah mřížky
     *  -3 = špatné souřadnice, již hrané pole
     * @throws IOException 
     */
    public String play(int x, int y) throws IOException;
}
