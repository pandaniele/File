package com.example.file;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;
import java.nio.charset.StandardCharsets;

public class GestoreFile {
    String nomeFile;

    public GestoreFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }
    public GestoreFile() {

    }
                                    //interfaccie utente passano per l'activity
    public String readFile(String nf, Context c){

        //  Context=riferimento a tutti gli oggetti nella MainActivity (che serve):

                                           //oggetto di tipo rider

                                          //trasforma stream di bte in caratteri

        StringBuilder sb=new StringBuilder();
        try {
                                                           //classe di wrapping trasforma da bit a carattere.
                                                            //nf file da trasformare da bit a carattere.
            BufferedReader fileDaLeggere=new BufferedReader(new InputStreamReader(c.openFileInput(nf)));
                                                                                        //eccezioni.
            String testoDaRestituire="";

            //feof non esiste
            //feof nella BuffeReadReader e' null=fine della riga;

            //ciclo il file da leggere con readLine()=prendo ogni riga ogni volta e lo metto nella stringa.
            while((testoDaRestituire=fileDaLeggere.readLine())!=null){
                                                    //eccezione 2= readLine non puo' riceveere valore Null.


                sb.append(testoDaRestituire +"\n");
            }

            //POTREBBE GENERARE UN'ECCEZIONE CHE DOBBIAMO CONTROLLARE!!!!!


            // I CATCH SONO LE ISTRUZIONI CHE VENGONO ESEGUITE SOLO DOPO I PROBLEMI ALTRIMENTI SI BLOCCA L'ISTRUZIONE
        } catch (FileNotFoundException e) {
            //ECCEZZIONE CONTROLLATA (FILE INESISTENTE)
            //LOG.E RRORE nel logcat in ROSSO colore
            Log.e("GESTORE", "file inesistente");

            //C'E' UN PROBLEMA CHE PUO' BLOCCARE IL PROGRAMMA
        } catch (IOException e) {
            Log.e("GESTORE", "ERRORE nella lettura del File");
        }

        //lettore dei file
        //stringa Builer che popolo leggendo dal file di testo riga per riga.
       return sb.toString();
    }

//ECCEZIONI CONTOLLATE LE CONTROLLA IDE E IL PROGRAMMATORE LE DEVE GESTIRE (IOEXPECTION).
    //ECCEZIONI NON CONTROLLATE COME LA ROUNTIMEERROR
    public String scriviFile(String nomefile, Context c)
    {
        FileOutputStream fileO; //
        String esito;
        String testodascrivere="Questo e' il testo da scrivere nel file";

        try {
                                                  //tipo di accesso al file
            fileO=c.openFileOutput(nomefile,Context.MODE_PRIVATE);
//OPENFILE==METODO DEL CONTEXT CHE TI RESTITUISCE UN OGGETTO DELLA CLASSE.
                 //testo da scrivere in byte percio' converto
            fileO.write(testodascrivere.getBytes(StandardCharsets.UTF_8));
            //
            //ecceione perche' 2 processi srivono il file
            fileO.close();
            //salva con nome automatico nel file
            esito="file scitto corrttamente";
        }
        catch (FileNotFoundException e) {
            esito="attenzione non sono riuscito a creare il file";
        }

        catch (IOException e) {
            esito="errore in fase di scrittura del file";
        }
        //eccezione non riesce a gestire questo metodo.
        return esito;
    }
                                //file li prendo dall'activity a cui io faccio riferimento
    public String leggiRawFile (Context c){

        StringBuilder sb=new StringBuilder();
        //c=activity
        //////////////
        Resources res=c.getResources();
        //puntatore alle risorse res
        InputStream is= res.openRawResource(R.raw.brani);
        //sono i byte del file
                                              //bit in caratteri
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        //ciclo per leggere il file

        String testoDaRestituire="";

        try {
            while ((testoDaRestituire = br.readLine()) != null) {
                sb.append(testoDaRestituire +"\n");
            }
        }
      catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();

    }
    //leggere file dalla cartella rasset

    public String leggiAsset(Context c) {
        StringBuilder sb=new StringBuilder();
        AssetManager aa = c.getAssets();

        try {
            InputStream is = aa.open("AssetBrano.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String testoDaRestituire = "";

            while ((testoDaRestituire = br.readLine()) != null) {
                sb.append(testoDaRestituire + "\n");
            }
        }
        catch(IOException e){
                e.printStackTrace();
            }
            return sb.toString();
        }
    }


