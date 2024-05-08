import org.example.Question;
import org.example.Quiz;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuizTest {

    String pregunta1="¿Cuál es la capital de Francia?";
    String[] opciones1={"Madrid","Londres","Paris","Berlin"};
    int respuesta1=2;
    Question question=new Question(pregunta1,opciones1,respuesta1);
    Quiz quiz=new Quiz();


    @Test
    public void addQuestionTest(){
        quiz.addQuestion(question);
        assertEquals(1,quiz.getContadorPreguntas());
    }

    @Test
    public void comprobarRespuesta(){
        quiz.addQuestion(question);
        String value=quiz.addAnswerQuestion(2);
        assertEquals(value,"Correcto");
    }

}
