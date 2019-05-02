import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

// TODO: Replace this with your own data model type
export interface ProductTableItem {
  id: number;
  name: string;
  manufacture: string;
  cost: number;
}

// TODO: replace this with real data from your application
const EXAMPLE_DATA: ProductTableItem[] = [
  {id: 1, name: 'Hydrogen', manufacture: 'Vector', cost: 7100},
  {id: 2, name: 'Helium', manufacture: 'Vector', cost: 42},
  {id: 3, name: 'Lithium', manufacture: 'Vector', cost: 83},
  {id: 4, name: 'Beryllium', manufacture: 'Vector', cost: 1600},
  {id: 5, name: 'Boron', manufacture: 'Vector', cost: 5300},
  {id: 6, name: 'Carbon', manufacture: 'Vector', cost: 218},
  {id: 7, name: 'Nitrogen', manufacture: 'Vector', cost: 428},
  {id: 8, name: 'Oxygen', manufacture: 'Vector', cost: 12300},
  {id: 9, name: 'Fluorine', manufacture: 'Vector', cost: 3700},
  {id: 10, name: 'Neon', manufacture: 'Vector', cost: 2900},
];

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource: MatTableDataSource<ProductTableItem>;

  displayedColumns = ['id', 'name', 'manufacture', 'cost'];

  ngOnInit() {
    this.dataSource = new MatTableDataSource(EXAMPLE_DATA);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
