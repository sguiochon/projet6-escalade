package sam.ocr.escalade.listener;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mockemail")
public class MockCommentAddedListener implements ICommentAddedListener {
    @Override
    public void onApplicationEvent(OnCommentAddedEvent onCommentAddedEvent) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> demande de validation de commentaire traitée!! <<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
