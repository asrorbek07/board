package io.vizend.board.aggregate.post.domain.entity.vo;

public enum PostState {
    //
    OPEN("OPEN"),
    CLOSED("CLOSED");

    private String value;

    PostState(String value) {
        this.value = value;
    }

    public static PostState fromString(String value) {
        PostState postState;
        value = value.toUpperCase();
        switch (value) {
            case "OPEN":
                postState = PostState.OPEN;
                break;
            case "CLOSED":
                postState = PostState.CLOSED;
                break;
            default:
                throw new IllegalArgumentException("Invalid Input: " + value);
        }
        return postState;
    }
}
