
import java.util.Comparator;

public class FollowComparator implements Comparator<Follow> {
    @Override
    public int compare(Follow f1, Follow f2) {
        // Compara primeiro pelo ID de quem é seguido (followedId)
        int followedCompare = f1.getFollowedId().compareTo(f2.getFollowedId());
        if (followedCompare != 0) {
            return followedCompare;
        }
        // Se os followedIds forem iguais, desempata pelo ID de quem segue (followerId)
        return f1.getFollowerId().compareTo(f2.getFollowerId());
    }
}
