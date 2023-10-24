package com.bouali.gestiondestock.controller;

import com.bouali.gestiondestock.controller.api.MvtStkApi;
import com.bouali.gestiondestock.dto.ArticleDto;
import com.bouali.gestiondestock.dto.MvtStkDto;
import com.bouali.gestiondestock.repository.ArticleRepository;
import com.bouali.gestiondestock.repository.MvtStkRepository;
import com.bouali.gestiondestock.services.MvtStkService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MvtStkController implements MvtStkApi {

  private MvtStkService service;
  private ArticleRepository articleRepository;


  @Autowired
  public MvtStkController(MvtStkService service,ArticleRepository articleRepository) {
    this.service = service;
    this.articleRepository =articleRepository;
  }

  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    return service.stockReelArticle(idArticle);
  }

  @Override
  public List<MvtStkDto> mvtStkArticle(Integer idArticle) {
    return service.mvtStkArticle(idArticle);
  }

  @Override
  public MvtStkDto entreeStock(MvtStkDto dto) {
    return service.entreeStock(dto);
  }

  @Override
  public MvtStkDto sortieStock(MvtStkDto dto) {
    return service.sortieStock(dto);
  }

  @Override
  public MvtStkDto correctionStockPos(MvtStkDto dto) {
    return service.correctionStockPos(dto);
  }

  @Override
  public MvtStkDto correctionStockNeg(MvtStkDto dto) {
    return service.correctionStockNeg(dto);
  }


}
