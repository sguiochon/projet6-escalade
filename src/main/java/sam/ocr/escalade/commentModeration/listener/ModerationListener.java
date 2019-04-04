package sam.ocr.escalade.commentModeration.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sam.ocr.escalade.commentModeration.OnCommentSubmissionEvent;

@Component
public class ModerationListener implements ApplicationListener<OnCommentSubmissionEvent> {

    @Override
    public void onApplicationEvent(OnCommentSubmissionEvent onCommentSubmissionEvent) {
        System.out.println("########################################## Commentaire soumis!!!! #################");
    }
}
