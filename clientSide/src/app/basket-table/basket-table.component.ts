import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {ProductService} from "../services/product.service";

export interface BasketTableItem {
  id: number;
  name: string;
  manufacture: ManufactureItem;
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

@Component({
  selector: 'app-basket-table',
  templateUrl: './basket-table.component.html',
  styleUrls: ['./basket-table.component.css']
})
export class BasketTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource = new MatTableDataSource<BasketTableItem>();

  constructor(private productService: ProductService) {
  }

  displayedColumns = ['id', 'name', 'manufacture', 'quantity', 'cost'];

  ngOnInit(): void {
    this.getAllProductsFromBasket();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  getAllProductsFromBasket() {
    let productMap = new Map<number, number>(JSON.parse(localStorage.getItem('basket')));

    let productKeys = Array.from(productMap.keys());

    this.productService.getAllProductsByIds(productKeys)
      .subscribe(res => {
        let resArray = res as BasketTableItem[];

        resArray.map(res => {
          res.quantity = productMap.get(res.id);
        });

        this.dataSource.data = resArray;
      })
  }

  getTotalQuantity() {
    return this.dataSource.data.map(t => t.quantity).reduce((acc, value) => acc + value, 0);
  }

  getTotalCost() {
    return this.dataSource.data.reduce((acc, value) => acc + value.cost * value.quantity, 0);
  }
}
