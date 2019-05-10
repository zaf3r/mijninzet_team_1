package makeitwork.mijninzet.repository;

import makeitwork.mijninzet.model.GlobalAvalablity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalAvalabilityRepository extends JpaRepository <GlobalAvalablity, Integer> {

    //deze functie saved alle entities als dagen.
    //GlobalAvalablity saveAll(Iterable<S> dag);
    //GlobalAvalability findall(Iterable<S> dag);
}
