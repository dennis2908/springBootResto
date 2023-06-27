package io.hamza.recipemanagement.branch;

import io.hamza.recipemanagement.resto.Resto;
import io.hamza.recipemanagement.resto.RestoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    private BranchRepository branchRepository;
    private RestoRepository restoRepository;

    public BranchService(BranchRepository branchRepository, RestoRepository restoRepository) {
        this.branchRepository = branchRepository;
        this.restoRepository = restoRepository;
    }

    @Transactional
    public Branch createBranchWithRestos(Branch branch, List<Resto> restos){

        restos.stream().forEach(resto -> resto.setBranch(branch));

        this.branchRepository.save(branch);
        this.restoRepository.saveAll(restos);

        return branch;
    }

    public List<Branch> getBranchs(){
        System.out.println(this.branchRepository.findAll());
        return this.branchRepository.findAll();
    }

    public Long getNumberOfBranchs(){
        return this.branchRepository.count();
    }
}