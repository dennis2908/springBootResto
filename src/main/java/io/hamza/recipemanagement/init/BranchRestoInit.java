package io.hamza.recipemanagement.init;

import io.hamza.recipemanagement.branch.Branch;
import io.hamza.recipemanagement.branch.BranchService;
import io.hamza.recipemanagement.resto.Resto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date;


@Component
public class BranchRestoInit implements CommandLineRunner {

    private final BranchService branchService;

    public BranchRestoInit(BranchService branchService) {
        this.branchService = branchService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(branchService.getNumberOfBranchs() > 1) {
            System.out.println("Branchs already initialized!");
            return;
        }

        String sDate1="31/12/1998";  
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  

        Branch branch1 = new Branch("Jakarta");
        Branch branch2 = new Branch("Bandung");
        Branch branch3 = new Branch("Surabaya");

        List<Resto> branch1Restos = Arrays.asList(
                new Resto("Senen Resto","Jalan Pasar Senen"),
                new Resto("Pasar Minggu Resto","Jalan Pasar Minggu 1"),
                new Resto("Blok M Resto","Jalan Raya Blok M blok D")
        );

        List<Resto> branch2Restos = Arrays.asList(
                new Resto("Cimanuk Resto","Jl. Cimanuk No. 08, Bandung 40115 Indonesia"),
                new Resto("Cihampelas Resto", "Jl. Cihampelas no. 211-217 Grand Tjokro Bandung Hotel, Bandung 40131 Indonesia"),
                new Resto("Mardinata Resto","Jl. RE. Martadinata no. 97, Bandung 40115 Indonesia")
        );

        branchService.createBranchWithRestos(branch1,branch1Restos);
        branchService.createBranchWithRestos(branch2,branch2Restos);
        branchService.createBranchWithRestos(branch3,new ArrayList<>());

    }
}
