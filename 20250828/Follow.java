import java.util.Objects;

public class Follow implements Comparable<Follow> {

    private Long followerId;
    private Long followedId;

    public Follow(Long followerId, Long followedId) {
        this.followerId = followerId;
        this.followedId = followedId;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followerId=" + followerId +
                ", followedId=" + followedId +
                '}';
    }

    @Override
    public int compareTo(Follow other) {
        int followerCompare = this.followerId.compareTo(other.followerId);
        if (followerCompare != 0) {
            return followerCompare;
        }
        return this.followedId.compareTo(other.followedId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(followerId, follow.followerId) &&
               Objects.equals(followedId, follow.followedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerId, followedId);
    }
}
