package com.example.kinito;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Objects;

public class Rules extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        Objects.requireNonNull(getSupportActionBar()).hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        ImageView ita = findViewById(R.id.ita);
        ImageView eng = findViewById(R.id.eng);
        ImageView imageLogo = findViewById(R.id.imageLogo);
        ScrollView scrollView = findViewById(R.id.scrollView);
        TextView textRules = findViewById(R.id.textRules);
        String italianRules = "Regole: \n Kinito è un gioco alcolico basato sulla birra, il gioco prosegue per eliminazione dei giocatori e il vincitore è l'ultimo rimasto. Un giocatore viene eliminato quando non è più in grado di bere o vomita. \n La quantità di birra da bere si misura in tacche: un piccolo bicchiere contiene 3 tacche. Al gioco possono partecipare qualsiasi numero di giocatori, il più giovane comincia con il controllo dei dadi e il CAPPELLINO (spiegato più giù). \nIl giocatore con il controllo dei dadi continua a tirarli e per ogni tiro vengono eseguite azioni diverse, questo finchè non ottiene NEXT/NULLO, a questo punto i dadi vengono passati al giocatore successivo in modo circolare. \n\nOgni tiro di dadi può avere diverse conseguenze: \n - somma 7: KINITO!, ogni giocatore esclama KINITO e l'ultimo a pronunciare la parola beve una TACCA \n\n - somma 3: BISCUITS, stessa logica del precedente, ma la parola è BISCUITS, \n\n - somma 10: BRINDISI!, ogni giocatore beve una tacca \n\n - somma 9: il giocatore precedente al possessore dei dadi beve una tacca \n\n - somma 11: il giocatore successivo al possessore dei dadi beve una tacca \n\n - due dadi uguali: il giocatore con il controllo dei dadi deve distribuire X tacche agli altri giocatori (X è il numero uscito sul singolo dado) \n per esempio: se il lancio è 2-2, il giocatore che ha tirato può assegnare 2 tacche agli altri giocatori, può distribuire le tacche tra i giocatori e persino assegnarle a sè stesso \n\n - uno ( o entrambi) dei risultati è 3: se il possessore dei dadi non ha il CAPPELLINO -> il giocatore con il CAPPELLINO beve una tacca \n Se il giocatore che possiede i dadi ha il CAPPELLINO, il giocatore beve una tacca mentre il cappellino diventa vagante e nessun giocatore lo possiede, il prossimo giocatore che tira un 3 otterrà il CAPPELLINO (anche il giocatore che ha appena perso il CAPPELLINO può riprenderlo). \n Quindi se il giocatore con il CAPPELLINO tira 3-3 dovrà distribuire 3 tacche ai giocatori (perchè il valore dei dadi è lo stesso ed è 3), inoltre esso perde il CAPPELLINO (e beve una tacca), dopodichè esso riprende il CAPPELLINO \n\n - NEXT/NULLO: i dadi passano al giocatore successivo\n\n - combinazione 2-4: HARRY POTTER!, dopo questa combinazione il giocatore con il possesso dei dadi ne tira uno alla volta (tutte le combinazioni precedenti non valgono in questa fase) \n Se il possessore dei dadi ripete la sequenza 2-4 (o 4-2) un dado alla volta esso diventerà HARRY POTTER e dovrà bere TUTTO ciò che è presente sul tavolo; Dopodichè toccherà al giocatore successivo.\n Se la sequenza di tiri singoli non è 2-4 (o 4-2) il gioco ritorna alla normalità con un NULLO (i dadi passano al giocatore successivo)" ;
        String englishRules = "Rules: \n Kinito is an alcoholic game meant to be played with beer, the game has a last man standing philosophy in which the winner is the last player left. A player left the game when he can drink no more, or if he puke. The amount of beer to be drinked has a unit: a small glass of beer is composed of three units. The game could be played by any number of players, the younger player in the game starts with the control of the dices and the HAT (more on this later). The player with the control of the dices keep playing and rolling until he gets NEXT, now the dices are controlled by the next player, and so on in a circular way. \n \n In every dice roll something will happen based on the outcome: \n - total of 7: KINITO!, every player have to say KINITO, the last one will drink one unit. \n\n - total of 3: BISCUITS!, every player have to say BISCUITS, the last one will drink one unit. \n\n - total of 10: CHEERS!, is time to have a cheer so everyone drink a unit. \n\n - total of 9: the player before me in the circle of players has to drink a unit. \n\n - total of 11: the player after me in the circle of players has to drink a unit. \n\n - two equal dice: the player that has rolled have to distribute X units to the other (where X is the number in a single dice), \n for example: if the outcome is 2-2, the player who rolled this outcome has to assign 2 units in total to the other players. He can distribute the units as he prefer and he could also assign units to himself. \n - one (or both) of the two dices is 3: if the player that has rolled the dices has not the HAT -> the player with the HAT will drink one unit. (2 units in case of double 3) \n if the player that have rolled the 3, has the HAT, he looses it and he drink one unit. Now the HAT is non-assigned and the next player that rolls a 3 will get it (also the player that has just lost the HAT could retake it). \n So if the player with the HAT rolls 3-3 he have to distribute 3 units, he will lose the HAT (and drink one unit) and he will retake the HAT. \n \n - NEXT: the next player in the circle will take the control of the dices \n\n - 2-4 combo called HARRY POTTER: after this combo the player that has the dices start to roll only one of them (all the previous combinations are not considered here), if he re-play the 4-2 (or 2-4) combo one dice at time e will become HARRY POTTER and he will drink EVERYTHING that is on the table :) After that, is the turn of the next player.\n If the sequence is not 2-4 (or 4-2) the game came back to normal with a NEXT (so it's the turn of the next player)";
        ita.setClipToOutline(true);
        ita.setImageAlpha(100);
        eng.setImageAlpha(100);
        eng.setClipToOutline(true);
        imageLogo.setClipToOutline(true);
        scrollView.setClipToOutline(true);

        //start with italian as default
        eng.setImageAlpha(100);
        ita.setImageAlpha(255);
        textRules.setText(italianRules);


        ita.setOnClickListener(v -> {
            eng.setImageAlpha(100);
            ita.setImageAlpha(255);
            textRules.setText(italianRules);

        });

        eng.setOnClickListener(v -> {
            eng.setImageAlpha(255);
            ita.setImageAlpha(100);
            textRules.setText(englishRules);

        });

    }
}