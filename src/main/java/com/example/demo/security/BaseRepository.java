package com.example.demo.security;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends PagingAndSortingRepository<T, Long> {

    @Query("select p from #{#entityName} p where p.tenant.id = ?#{principal.tenant.id} and p.active = true")
    Page<T> findAll(Pageable pageable);

    @Query("update #{#entityName} p set p.active = false where p.id = ?1 and p.tenant.id = ?#{principal.tenant.id}")
    @Override
    void delete(Long aLong);

    @Override
    default void delete(T entity){
        delete(entity.getId());
    };

    @Override
    default void delete(Iterable<? extends T> entities){
        entities.forEach(entity-> delete(entity.getId()));
    };

    @Query("update #{#entityName} p set p.active = false where p.tenant.id = ?#{principal.tenant.id}")
    @Override
    void deleteAll();

    @Query("select count (p) from #{#entityName} p where p.tenant.id = ?#{principal.tenant.id} and p.active = true")
    @Override
    long count();

    default <S extends T> S insert(S entity){
        if(entity.getId() == null){
            return save(entity);
        }
        return null;
    }

    default <S extends T> S update(S entity) throws Exception {
        String authentication = (String)  SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("STRING UPDATE  " + authentication );

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

        EntityManager manager = factory.createEntityManager();

       // manager.find(UserModel.class, )

       // if(authentication.getTenantModel().getId().equals(entity.getTenantModel().getId())){
            return save(entity);
        //}
       // throw new Exception("erro exception");
    }
}
