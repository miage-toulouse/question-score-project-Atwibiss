package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple questions;

    @Before
    public void setUp() throws Exception {
        List<Integer> indicesBonnesReponses = new ArrayList<Integer>();
        indicesBonnesReponses.add(1);
        indicesBonnesReponses.add(2);
        questions = new QuestionAChoixMultiple("un énoncé", indicesBonnesReponses, 2);
    }

    @Test
    public void getEnonce() {
        //when : on demande l'énoncé à la question
        String resEnonce = questions.getEnonce();
        //then : l'énoncé est non null
        assertNotNull(resEnonce);
        //and : l'énoncé est bien celui fourni à la construction
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void getScoreForIndice() {
        //when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indiceEtudiant = 2;
        //and : on demande le calcul du score
        Float resScore = questions.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 100
        assertEquals(new Float(50f), resScore, 0.01f);
        //when : un étudiant fourni l'indice correspondant à une mauvaise réponse
        indiceEtudiant = 3;
        //and : on demande le calcul du score
        resScore = questions.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 0
        assertEquals(new Float(0f), resScore, 0.001f);
    }
}