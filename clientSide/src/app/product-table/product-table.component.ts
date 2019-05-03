import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {ProductService} from "../services/product.service";

export interface ProductTableItem {
  id: number;
  name: string;
  category: string;
  manufacture: ManufactureItem;
  inStock: boolean;
  quantity: number;
  cost: number;
}

export interface ManufactureItem {
  id: number;
  name: string;
  approved: boolean;
  products: unknown;
  userInfo: unknown;
}

export enum Category {
  Component = 'Компоненты',
  Device = 'Готовые устройства'
}

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private productService: ProductService) {
  }

  dataSource = new MatTableDataSource<ProductTableItem>();

  displayedColumns = ['id', 'name', 'category', 'manufacture', 'inStock', 'quantity', 'cost'];

  ngOnInit() {
    this.getAllProducts();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  getAllProducts() {
    this.productService.getAllProducts()
      .subscribe(res => {
        this.dataSource.data = res as ProductTableItem[];
      })
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  //Convert category type for correct view into table
  convertCategoryType(categoryType: string) {
    let categoryName;

    switch (categoryType) {
      case "Component":
        categoryName = Category.Component;
        break;
      case "Device":
        categoryName =  Category.Device;
        break;
      default:
        categoryName =  "";
    }

    return categoryName;
  }
}
