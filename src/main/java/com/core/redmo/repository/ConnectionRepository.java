//$Id$
package com.core.redmo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.core.redmo.entity.Connections;

@Repository
public interface ConnectionRepository extends JpaRepository<Connections,Long> {
      Optional<Connections> findByPortAndHost(int port,String host);
      Optional<Connections> findByConnectionName(String connectionName);
}
