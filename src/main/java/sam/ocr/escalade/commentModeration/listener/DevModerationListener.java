package sam.ocr.escalade.commentModeration.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import sam.ocr.escalade.commentModeration.OnCommentSubmissionEvent;

@Component
@Profile("dev")
public class DevModerationListener implements ApplicationListener<OnCommentSubmissionEvent> {

    @Override
    public void onApplicationEvent(OnCommentSubmissionEvent onCommentSubmissionEvent) {
        System.out.println("########################################## Commentaire soumis!!!! #################");
    }
}
