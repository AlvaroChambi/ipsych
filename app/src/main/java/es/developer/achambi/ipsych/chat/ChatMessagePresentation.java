package es.developer.achambi.ipsych.chat;

import android.content.Context;

import es.developer.achambi.coreframework.ui.presentation.SearchListData;
import es.developer.achambi.ipsych.DateFormatUtil;
import es.developer.achambi.ipsych.R;

public class ChatMessagePresentation implements SearchListData {
    private final int id;
    public final String userName;
    public final String timestamp;
    public final String message;
    public final boolean ownMessage;

    ChatMessagePresentation(int id, String userName, String timestamp, String message,
                            boolean ownMessage) {
        this.id = id;
        this.userName = userName;
        this.timestamp = timestamp;
        this.message = message;
        this.ownMessage = ownMessage;
    }

    public static class Builder {
        public static ChatMessagePresentation buildPresentation( Context context,
                                                                 String currentUser,
                                                                 ChatMessage message ) {
            return new ChatMessagePresentation(
                    (int)message.getId(),
                    message.getUser(),
                    DateFormatUtil.formatChatTimestamp(
                            context.getResources().getConfiguration().locale,
                            message.getMessageDate() ),
                    message.getMessage(),
                    currentUser.equals( message.getUser() )
            );
        }
    }

    @Override
    public int getViewType() {
        return R.id.chat_bubble_id;
    }

    @Override
    public int getId() {
        return id;
    }
}
